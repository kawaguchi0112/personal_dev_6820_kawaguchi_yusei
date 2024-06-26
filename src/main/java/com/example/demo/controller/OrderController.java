package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.model.Account;
import com.example.demo.model.Cart;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;

@Controller
public class OrderController {

	@Autowired
	Cart cart;

	@Autowired
	Account account;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Autowired
	ItemRepository itemRepository;

	@GetMapping("/order")
	public String index(Model model) {

		if (cart.getItems() == null || cart.getItems().size() == 0) {
			model.addAttribute("memo", "商品がありません");
			return "cart";

		}

		List<Customer> customerList = customerRepository.findByEmail(account.getEmail());

		Customer customer = customerList.get(0);

		model.addAttribute("customer", customer);

		return "customerForm";
	}

	@PostMapping("/cart/adds")
	public String addsCart(
			@RequestParam(name = "itemId", defaultValue = "") Integer[] itemId,
			@RequestParam(name = "quantity", defaultValue = "1") Integer[] quantity,
			@RequestParam(name = "o", defaultValue = "0") Integer o,
			Model model) {

		for (int i = 0; i < itemId.length; i++) {
			cart.adds(itemId[i], quantity[i]);
		}

		if (o == 1) {
			return "redirect:/items";
		}

		if (cart.getItems() == null || cart.getItems().size() == 0) {
			model.addAttribute("memo", "商品がありません");
			return "cart";

		}
		return "redirect:/order";

	}

	// 注文内容およびお客様情報内容の確認画面を表示
	@PostMapping("/order/confirm")
	public String confirm(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "tel", defaultValue = "") String tel,
			@RequestParam(name = "orderemail", defaultValue = "") String orderemail,
			@RequestParam(name = "email") String email,
			@RequestParam(name = "points", defaultValue = "0") Integer points,
			Model model) {

		model.addAttribute("dename", name);
		model.addAttribute("deaddress", address);
		model.addAttribute("detel", tel);
		model.addAttribute("orderemail", orderemail);
		model.addAttribute("points", points);

		// お客様情報をまとめる
		List<Customer> customer = customerRepository.findByEmail(email);

		Customer c = customer.get(0);

		if (c.getPoint() < points) {

			model.addAttribute("customer", c);
			model.addAttribute("mess", "ポイントが不足しています");
			return "customerForm";
		}

		if (cart.getTotalPrice() < points) {

			model.addAttribute("customer", c);
			model.addAttribute("mess", "ポイントを使いすぎています.");
			return "customerForm";
		}

		int p = cart.getTotalPrice() - points;

		model.addAttribute("p", p);

		model.addAttribute("points", points);

		model.addAttribute("customer", c);

		List<String> list = new ArrayList<>();
		if (name.equals("")) {
			list.add("名前は必須です");
		}
		if (address.equals("")) {
			list.add("住所は必須です");
		}
		if (tel.equals("")) {
			list.add("電話番号は必須です");
		}
		if (orderemail.equals("")) {
			list.add("メールアドレスは必須です");
		}

		if (list.size() > 0) {
			model.addAttribute("lis", list);
			model.addAttribute("customer", c);
			return "customerForm";
		}

		return "orderConfirm";
	}

	// 注文する
	@PostMapping("/order")
	public String order(
			@RequestParam("name") String name,
			@RequestParam("address") String address,
			@RequestParam("email") String email,
			@RequestParam("points") Integer points,
			Model model) {

		// 1. お客様情報をDBに格納する
		Customer customer = new Customer(name, address);
		model.addAttribute("customer", customer);

		List<Customer> customerlist = customerRepository.findByEmail(email);

		Customer c = customerlist.get(0);

		// 2. 注文情報をDBに格納する
		Order order = new Order(
				c.getId(),
				LocalDate.now(),
				cart.getTotalPrice() - points,
				cart.getTotalPrice(),
				points);
		orderRepository.save(order);

		// 3. 注文詳細情報をDBに格納する
		List<Item> itemList = cart.getItems();
		List<OrderDetail> orderDetails = new ArrayList<>();
		for (Item item : itemList) {
			orderDetails.add(
					new OrderDetail(
							order.getId(),
							item.getId(),
							item.getQuantity(),
							c.getId()));
		}
		orderDetailRepository.saveAll(orderDetails);

		int tp = c.getPoint() + (int) (cart.getTotalPrice() * 0.01) - points;

		c.setPoint(tp);

		int getPoint = (int) (cart.getTotalPrice() * 0.01);
		model.addAttribute("getPoint", getPoint);

		customerRepository.save(c);
		account.setPoint(tp);

		// セッションスコープのカート情報をクリアする
		cart.clear();

		// 画面返却用注文番号を設定する
		model.addAttribute("orderNumber", order.getId());
		model.addAttribute("customer", c);

		return "ordered";
	}

}
