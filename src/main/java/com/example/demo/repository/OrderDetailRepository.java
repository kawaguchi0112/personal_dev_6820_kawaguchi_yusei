package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

	List<OrderDetail> findByItemId(Integer itemId);

	List<OrderDetail> findByCustomerId(Integer customerId);

}
