package com.hexaware.veggies.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.veggies.entity.Manager;
import com.hexaware.veggies.exception.ResourceNotFoundException;
import com.hexaware.veggies.service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private ManagerService managerService;
    
	@PostMapping("/addManager")
	public ResponseEntity<String> addManager(@Valid @RequestBody Manager manager){
		Manager rmanager = managerService.addManager(manager);
		if(rmanager!=null)
			return new ResponseEntity<>("Successfull added manager", HttpStatus.OK);
		else
			return new ResponseEntity<>("Successfull not added manager", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getallmanagers")
	public List<Manager> getAllManager(){
		return managerService.getAllManagers();
		
	}
	@PutMapping("/updatemanager/{mid}")
	public Manager updateManager(@Valid @RequestBody Manager newManager,@PathVariable("mid") Long managerId) throws ResourceNotFoundException {
		Manager manager =  managerService.getManagerById(managerId)
				.orElseThrow(() -> new ResourceNotFoundException("Manager not exists with id" +managerId));

		manager.setFirstName(newManager.getFirstName());
		manager.setLastName(newManager.getLastName());
		manager.setEmail(newManager.getEmail());
		manager.setUserName(newManager.getUserName());
		manager.setPassword(newManager.getPassword());
		
		
		
		return managerService.updateManager(manager);
		
	}
	
	@GetMapping("/findmanagerbyid/{mid}")
	public Manager getManagerById(@PathVariable("mid") Long managerId){
		return managerService.getManagerById(managerId).get();
	}
	
	@DeleteMapping("/deletemanager/{mid}")
	public void deleteManagerById(@PathVariable("mid") Long managerId){
		 managerService.deleteManagerById(managerId);
	}
	
	@GetMapping("/findmanager/{musername}")
	public Manager getManagerByName(@PathVariable("mname") String userName){
		return managerService.getManagerByUserName(userName);
	}
	
	
	
	
}