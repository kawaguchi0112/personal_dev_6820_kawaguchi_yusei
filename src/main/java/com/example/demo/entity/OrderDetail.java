package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // 注文明細ID

	@Column(name = "order_id")
	private Integer orderId; // 注文ID

	@Column(name = "item_id")
	private Integer itemId; // 商品ID

	private Integer quantity; // 数量

	@Column(name = "customer_id")
	private Integer customerId;

	// コンストラクタ
	public OrderDetail() {
	}

	public OrderDetail(Integer orderId, Integer itemId, Integer quantity) {
		this.orderId = orderId;
		this.itemId = itemId;
		this.setQuantity(quantity);
	}

	public OrderDetail(Integer orderId, Integer itemId, Integer quantity, Integer customerId) {
		this.orderId = orderId;
		this.itemId = itemId;
		this.setQuantity(quantity);
		this.customerId = customerId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
}
