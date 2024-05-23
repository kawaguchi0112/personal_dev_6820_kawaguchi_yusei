package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "favorites")
public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "item_id")
	private Integer itemId;

	public Favorite() {

	}

	public Favorite(Integer customerId, Integer itemId) {
		this.customerId = customerId;
		this.itemId = itemId;

	}

	public Integer getId() {
		return id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
}
