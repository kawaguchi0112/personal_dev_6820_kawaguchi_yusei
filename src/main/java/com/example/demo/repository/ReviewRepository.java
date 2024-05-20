package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Reviews;

public interface ReviewRepository extends JpaRepository<Reviews, Integer> {

	List<Reviews> findByItemId(Integer itemId);

}
