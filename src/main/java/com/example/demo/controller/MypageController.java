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
public class MypageController {

	@Autowired
	HttpSession session;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	Account account;

	@GetMapping("/Mypage")
	public String Mypage(
			Model model) {
		List<Customer> customerList = customerRepository.findByEmail(account.getEmail());

		Customer customer = customerList.get(0);

		model.addAttribute("customer", customer);

		return "Mypage";
	}

	@GetMapping("/Mypage/edit")
	public String edit(@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "tel", defaultValue = "") String tel,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "pass", defaultValue = "") String pass,
			@RequestParam(name = "point", defaultValue = "") Integer point,
			@RequestParam(name = "e", defaultValue = "1") Integer e,
			Model model) {
		List<Customer> customerList = customerRepository.findByEmail(account.getEmail());

		Customer customer = customerList.get(0);

		model.addAttribute("customer", customer);

		customer.setName(name);
		customer.setAddress(address);
		customer.setTel(tel);
		customer.setEmail(email);
		customer.setPass(pass);

		account.setName(name);
		account.setEmail(email);
		account.setPass(pass);

		model.addAttribute("e", e);

		customerRepository.save(customer);
		model.addAttribute("memo", "以下の内容で登録しました");

		return "newMypage";
	}

	@PostMapping("/Mypage")
	public String my(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "tel", defaultValue = "") String tel,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "pass", defaultValue = "") String pass,
			@RequestParam(name = "point", defaultValue = "") Integer point,
			@RequestParam(name = "e", defaultValue = "1") Integer e,
			Model model) {

		List<Customer> customerList = customerRepository.findByEmail(account.getEmail());

		Customer customer = customerList.get(0);

		model.addAttribute("customer", customer);

		List<Customer> emailList = customerRepository.findByEmail(email);

		List<Customer> telList = customerRepository.findByTel(tel);

		List<String> list = new ArrayList<>();

		if (name.equals("")) {
			list.add("名前は必須です");
		}
		if (address.equals("")) {
			list.add("住所は必須です");
		}
		if (tel.equals("")) {
			list.add("電話番号は必須です");
		} else if (telList != null && telList.size() > 0) {
			Customer newtel = telList.get(0);
			if (newtel.getId() != customer.getId()) {
				list.add("その電話番号は登録済みです");
			}
		}

		if (email.equals("")) {
			list.add("メールアドレスは必須です");
		} else if (emailList != null && emailList.size() > 0) {
			Customer newemail = emailList.get(0);
			if (newemail.getId() != customer.getId()) {
				list.add("そのメールアドレスは登録済みです");
			}
		}

		if (pass.equals("")) {
			list.add("パスワードは必須です");
		}

		if (list.size() > 0) {
			model.addAttribute("list", list);
			return "Mypage";
		}

		customer.setName(name);
		customer.setAddress(address);
		customer.setTel(tel);
		customer.setEmail(email);
		customer.setPass(pass);

		model.addAttribute("e", e);

		return "newMypage";

	}

}
