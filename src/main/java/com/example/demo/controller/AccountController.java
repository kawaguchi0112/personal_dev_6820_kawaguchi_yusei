package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.model.Account;
import com.example.demo.repository.CustomerRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {

	@Autowired
	HttpSession session;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	Account account;

	@GetMapping({ "/", "/login", "/logout" })
	public String index(
			@RequestParam(name = "error", defaultValue = "") String error,
			Model model) {
		session.invalidate();

		if (error.equals("notLoggedIn")) {
			model.addAttribute("message", "ログインして下さい");
		}

		return "login";
	}

	@PostMapping("/login")
	public String login(
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "pass", defaultValue = "") String pass,
			Model model) {

		List<Customer> customerList = customerRepository.findByEmailAndPass(email, pass);

		if (customerList == null || customerList.size() == 0) {
			model.addAttribute("message", "メールアドレスとパスワードが一致しませんでした");
			return "login";
		}

		Customer customer = customerList.get(0);
		account.setEmail(customer.getEmail());
		account.setPass(customer.getPass());
		account.setName(customer.getName());
		account.setPoint(customer.getPoint());

		return "redirect:/items";
	}

	@GetMapping("/sigin")
	public String sigin() {
		return "sigin";
	}

	@PostMapping("/sigin")
	public String siginUp(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "tel", defaultValue = "") String tel,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "pass", defaultValue = "") String pass,
			@RequestParam(name = "point", defaultValue = "") Integer point,
			Model model) {

		List<String> list = new ArrayList<>();

		List<Customer> telList = customerRepository.findByTel(tel);
		List<Customer> emailList = customerRepository.findByEmail(email);

		if (name.equals("")) {
			list.add("名前は必須です");
		}
		if (address.equals("")) {
			list.add("住所は必須です");
		}
		if (tel.equals("")) {
			list.add("電話番号は必須です");
		} else if (telList != null && telList.size() > 0) {
			list.add("その電話番号は登録済みです");
		}

		if (email.equals("")) {
			list.add("メールアドレスは必須です");
		} else if (emailList != null && emailList.size() > 0) {
			list.add("そのメールアドレスは登録済みです");
		}
		if (pass.equals("")) {
			list.add("パスワードは必須です");
		}

		if (list.size() > 0) {
			model.addAttribute("list", list);
			return "sigin";
		}

		Customer customer = new Customer(name, address, tel, email, pass, point);
		customerRepository.save(customer);

		return "redirect:/login";

	}

}
