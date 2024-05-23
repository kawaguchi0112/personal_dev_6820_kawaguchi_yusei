package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

	List<Favorite> findByItemId(Integer itemId);

	List<Favorite> findByCustomerId(Integer customerId);

}
