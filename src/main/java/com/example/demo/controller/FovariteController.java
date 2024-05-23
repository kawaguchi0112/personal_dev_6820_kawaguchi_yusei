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
import com.example.demo.entity.Favorite;
import com.example.demo.entity.Item;
import com.example.demo.model.Account;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.FavoriteRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class FovariteController {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	FavoriteRepository favoriteRepository;

	@Autowired
	Account account;

	@GetMapping("/favorite")
	public String favorite(Model model) {
		List<Customer> customerList = customerRepository.findByEmail(account.getEmail());
		Customer customer = customerList.get(0);

		List<Favorite> lo = favoriteRepository.findAll();

		List<Item> existsItem = new ArrayList<>();

		for (Favorite lists : lo) {
			if (lists.getCustomerId() == customer.getId()) {
				Item st = itemRepository.findById(lists.getItemId()).get();
				existsItem.add(st);
			}

			model.addAttribute("list", existsItem);
		}

		return "favorite";
	}

	@PostMapping("/favorite/add")
	public String fadd(
			@RequestParam(name = "itemId") Integer itemId,
			Model model) {
		List<Customer> customerList = customerRepository.findByEmail(account.getEmail());
		Customer customer = customerList.get(0);

		List<Favorite> faList = favoriteRepository.findByItemId(itemId);

		for (Favorite fa : faList) {
			if (fa.getCustomerId() == customer.getId()) {
				favoriteRepository.deleteById(fa.getId());
				return "redirect:/items";
			}
		}
		Favorite favo = new Favorite(customer.getId(), itemId);

		favoriteRepository.save(favo);

		return "redirect:/items";
	}

	@PostMapping("/favorite/de")
	public String fde(
			@RequestParam(name = "itemId") Integer itemId,
			Model model) {
		List<Customer> customerList = customerRepository.findByEmail(account.getEmail());
		Customer customer = customerList.get(0);

		List<Favorite> faList = favoriteRepository.findByItemId(itemId);

		for (Favorite fa : faList) {
			if (fa.getCustomerId() == customer.getId()) {
				favoriteRepository.deleteById(fa.getId());
			}
		}

		return "redirect:/favorite";
	}

}
