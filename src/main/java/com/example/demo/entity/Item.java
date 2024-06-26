package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "category_id")
	private Integer categoryId;

	private String name;

	private Integer price;

	private double avgpoint;

	@Transient
	private String favorite;

	@Transient
	private Integer quantity;

	@Transient
	private Integer history;

	public Item() {

	}

	public Item(Integer id, String name, Integer price, double avgpoint, String favorite) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.avgpoint = avgpoint;
		this.favorite = favorite;

	}

	public Item(Integer id, String name, Integer price, Integer history, Integer quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.history = history;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getAvgpoint() {
		return avgpoint;
	}

	public void setAvgpoint(double avgreviewpoint) {
		this.avgpoint = avgreviewpoint;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getFavorite() {
		return favorite;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

	public Integer getHistory() {
		return history;
	}

	public void setHistory(Integer history) {
		this.history = history;
	}

}
