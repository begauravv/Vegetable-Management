package com.hexaware.veggies.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.veggies.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long>{
	public Manager findByUserName(String userName);
	public Manager findByEmail(String email);

}
