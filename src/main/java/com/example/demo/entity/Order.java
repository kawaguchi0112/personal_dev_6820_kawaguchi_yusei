package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // 注文ID

	@Column(name = "customer_id")
	private Integer customerId; // 顧客ID

	@Column(name = "ordered_on")
	private LocalDate orderedOn; // 注文日

	private Integer payment;

	@Column(name = "total_price")
	private Integer totalPrice; // 合計金額

	private Integer usepoint;

	// コンストラクタ
	public Order() {
	}

	public Order(Integer customerId, LocalDate orderedOn, Integer payment, Integer totalPrice, Integer usepoint) {
		this.customerId = customerId;
		this.orderedOn = orderedOn;
		this.payment = payment;
		this.totalPrice = totalPrice;
		this.usepoint = usepoint;
	}

	// ゲッター
	public Integer getId() {
		return id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public LocalDate getOrderedOn() {
		return orderedOn;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public void setOrderedOn(LocalDate orderedOn) {
		this.orderedOn = orderedOn;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getPayment() {
		return payment;
	}

	public Integer getUsepoint() {
		return usepoint;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	public void setUsepoint(Integer usepoint) {
		this.usepoint = usepoint;
	}
}
