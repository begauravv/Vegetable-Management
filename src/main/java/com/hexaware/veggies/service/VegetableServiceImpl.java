package com.hexaware.veggies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.veggies.entity.Vegetable;
import com.hexaware.veggies.exception.ResourceNotFoundException;
import com.hexaware.veggies.repository.VegetableRepository;

@Service
public class VegetableServiceImpl implements VegetableService {
	
	@Autowired
	private VegetableRepository vegetableRepository;

	@Override
	public Vegetable addVegetable(Vegetable vegetable) {
		// TODO Auto-generated method stub
		return vegetableRepository.save(vegetable);
	}

	@Override
	public List<Vegetable> getAllVegetables() {
		// TODO Auto-generated method stub
		return vegetableRepository.findAll();
	}

	@Override
	public List<Vegetable> getVegetablesByManagerId(Long managerId) {
		// TODO Auto-generated method stub
		return vegetableRepository.findByManager_ManagerId(managerId);
	}

	@Override
	public Optional<Vegetable> getVegetableById(Long vegetableId) {
		// TODO Auto-generated method stub
		return vegetableRepository.findById(vegetableId);
	}

	@Override
	public Vegetable getVegetableByName(String vegetableName) {
		// TODO Auto-generated method stub
		return vegetableRepository.findByVegetableName(vegetableName);
	}

	@Override
	public void deleteVegetableById(Long vegetableId) {
		// TODO Auto-generated method stub
		vegetableRepository.deleteById(vegetableId);
		
	}

	@Override
	public Vegetable updateVegetable(Vegetable vegetable) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return vegetableRepository.save(vegetable);
	}
	
	

}
