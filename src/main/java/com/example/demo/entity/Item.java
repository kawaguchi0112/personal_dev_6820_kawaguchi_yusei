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

	private String avgpoint;

	@Transient
	private Integer quantity;

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

	public String getAvgpoint() {
		return avgpoint;
	}

	public void setAvgpoint(String avgreviewpoint) {
		this.avgpoint = avgreviewpoint;
	}

}