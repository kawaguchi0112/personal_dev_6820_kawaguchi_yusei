package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "item_id")
	private Integer itemId;

	private String review;

	private Integer reviewpoint;

	public Reviews() {

	}

	public Reviews(Integer itemId, String review, Integer reviewpoint) {
		this.itemId = itemId;
		this.review = review;
		this.reviewpoint = reviewpoint;
	}

	public Reviews(String review, Integer reviewpoint) {
		this.review = review;
		this.reviewpoint = reviewpoint;
	}

	public Integer getId() {
		return id;
	}

	public Integer getItemId() {
		return itemId;
	}

	public String getReview() {
		return review.replaceAll("\n", "<br>");
	}

	public Integer getReviewpoint() {
		return reviewpoint;
	}
}
