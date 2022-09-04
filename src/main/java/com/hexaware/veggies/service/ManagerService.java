package com.hexaware.veggies.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.veggies.entity.Manager;
import com.hexaware.veggies.exception.ResourceNotFoundException;

public interface ManagerService {
	Manager addManager(Manager manager);
	   List<Manager> getAllManagers();
	   Manager getManagerByUserName(String userName);
	   Optional<Manager> getManagerById(Long managerId);
	   
	   Manager getManagerByEmail(String email);
	   void deleteManagerById(Long managerId);
	   Manager updateManager(Manager manager) throws ResourceNotFoundException;
	   Boolean isLogin(String email, String password);
	   Boolean isUserExist(Manager manager);

}
