package com.hexaware.veggies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.veggies.entity.Vegetable;


public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
	public Vegetable findByVegetableName(String vegetableName);
	
}