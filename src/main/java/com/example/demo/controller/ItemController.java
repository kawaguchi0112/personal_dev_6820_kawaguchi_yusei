package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.entity.Reviews;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.ReviewRepository;

@Controller
public class ItemController {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	ReviewRepository reviewRepository;

	@GetMapping("/items")
	public String index(
			@RequestParam(value = "categoryId", defaultValue = "") Integer categoryId,
			@RequestParam(name = "sort", defaultValue = "") String sort,
			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			@RequestParam(name = "maxPrice", defaultValue = "") Integer maxPrice,
			@RequestParam(name = "s", defaultValue = "1") Integer s,
			Model model) {
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);

		List<Item> itemList = null;

		model.addAttribute("maxPrice", maxPrice);
		model.addAttribute("keyword", keyword);

		itemList = itemRepository.findAll();

		if (s == 1) {
			if (maxPrice != null && !keyword.equals("")) {
				itemList = itemRepository.findByPriceLessThanEqualAndNameContaining(maxPrice, keyword);
			} else if (maxPrice != null) {
				itemList = itemRepository.findByPriceLessThanEqual(maxPrice);
			} else if (keyword != null) {
				itemList = itemRepository.findByNameContaining(keyword);
			}
			if (sort.equals("priceAsc")) {
				itemList = itemRepository.findAllByOrderByPriceAsc();
			}
			if (sort.equals("pointDesc")) {
				itemList = itemRepository.findAllByOrderByAvgpointDesc();
			}
		}

		if (s == 2) {
			if (categoryId != null) {
				itemList = itemRepository.findByCategoryId(categoryId);
			} else {
				itemList = itemRepository.findAll();
			}
		}

		model.addAttribute("items", itemList);
		model.addAttribute("s", s);

		return "items";

	}

	@GetMapping("/items/{id}/info")
	public String show(
			@PathVariable("id") Integer id,
			@RequestParam(name = "review", defaultValue = "") String review,
			@RequestParam(name = "reviewpoint", defaultValue = "") Integer reviewpoint,
			@RequestParam(name = "se", defaultValue = "1") Integer se,
			Model model) {

		Item item = itemRepository.findById(id).get();
		model.addAttribute("item", item);
		model.addAttribute("se", se);

		List<Item> list = itemRepository.findByCategoryId(item.getCategoryId());

		List<Item> existsItem = new ArrayList<>();

		for (Item lists : list) {
			if (lists.getId() != id) {
				existsItem.add(lists);
			}
		}
		model.addAttribute("list", existsItem);

		model.addAttribute("review", review);
		model.addAttribute("reviewpoint", reviewpoint);

		List<Reviews> reviewList = reviewRepository.findByItemId(id);

		model.addAttribute("reviewList", reviewList);

		double avgreviewpoint = 0;
		double poin = 0;

		if (reviewList.size() != 0) {
			for (Reviews r : reviewList) {
				poin += r.getReviewpoint();
			}
			avgreviewpoint = poin / reviewList.size();

			model.addAttribute("avgreviewpoint", String.format("%.1f", avgreviewpoint));
		}

		item.setAvgpoint(avgreviewpoint);

		itemRepository.save(item);

		if (se != 1) {

			Reviews reviews = new Reviews(review, reviewpoint);
			model.addAttribute("reviews", reviews);
			model.addAttribute("me", "この内容で投稿しますか");
			return "info";
		}

		return "info";

	}

	@PostMapping("/items/{id}/info")
	public String review(
			@RequestParam("itemId") int itemId,
			@RequestParam(name = "review", defaultValue = "") String review,
			@RequestParam(name = "reviewpoint", defaultValue = "") Integer reviewpoint,
			Model model) {

		Reviews reviews = new Reviews(itemId, review, reviewpoint);

		reviewRepository.save(reviews);

		return "redirect:/items/{id}/info";

	}

}
