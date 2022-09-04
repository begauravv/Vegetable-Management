package com.hexaware.veggies.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.veggies.entity.Vegetable;
import com.hexaware.veggies.exception.ResourceNotFoundException;

public interface VegetableService {
	
	   Vegetable addVegetable(Vegetable customer);
	   List<Vegetable> getAllVegetables();
	   List<Vegetable> getVegetablesByManagerId(Long managerId);
	   Optional<Vegetable> getVegetableById(Long vegetableId);
	   Vegetable getVegetableByName(String vegetableName);
	   void deleteVegetableById(Long vegetableId);
	   Vegetable updateVegetable(Vegetable vegetable) throws ResourceNotFoundException;
}
