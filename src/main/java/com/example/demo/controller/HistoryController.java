package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.model.Account;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;

@Controller
public class HistoryController {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	Account account;

	@GetMapping("/history")
	public String history(Model model) {

		List<Customer> customerList = customerRepository.findByEmail(account.getEmail());
		Customer customer = customerList.get(0);

		List<OrderDetail> odcustomer = orderDetailRepository.findByCustomerId(customer.getId());

		List<Order> ocustomer = orderRepository.findByCustomerId(customer.getId());

		List<Item> Item = new ArrayList<>();

		for (OrderDetail od : odcustomer) {
			if (od.getItemId() != null) {
				Item item = itemRepository.findById(od.getItemId()).get();
				Item i = new Item(item.getId(), item.getName(), item.getPrice(), od.getOrderId(), od.getQuantity());
				Item.add(i);
			}
		}

		model.addAttribute("ocustomer", ocustomer);
		model.addAttribute("i", Item);

		return "history";
	}
}
