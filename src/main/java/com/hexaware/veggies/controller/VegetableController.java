package com.hexaware.veggies.controller;

import java.util.List;

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

import com.hexaware.veggies.entity.Vegetable;
import com.hexaware.veggies.exception.ResourceNotFoundException;
import com.hexaware.veggies.service.VegetableService;

@RestController
@RequestMapping("/vegetable")
public class VegetableController {
	
	@Autowired
	private VegetableService vegetableService;
	
	@PostMapping("/addVegetable")
	public ResponseEntity<String> addVegetable(@RequestBody Vegetable vegetable){
		Vegetable rvegetable = vegetableService.addVegetable(vegetable);
		if(rvegetable!=null)
			return new ResponseEntity<>("Successfull added vegetable", HttpStatus.OK);
		else
			return new ResponseEntity<>("Successfull not added vegetable", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/getallvegetables")
	public List<Vegetable> getAllVegetable(){
		return vegetableService.getAllVegetables();
		
	}
	@PutMapping("/updatevegetable/{mid}")
	public Vegetable updateVegetable(@RequestBody Vegetable newVegetable,@PathVariable("mid") Long vegetableId) throws ResourceNotFoundException {
		Vegetable vegetable =  vegetableService.getVegetableById(vegetableId)
				.orElseThrow(() -> new ResourceNotFoundException("Vegetable not exists with id" +vegetableId));

		vegetable.setVegetableName(newVegetable.getVegetableName());
		vegetable.setVegetablePrice(newVegetable.getVegetablePrice());
		vegetable.setVegetableDescription(newVegetable.getVegetableDescription());

		return vegetableService.updateVegetable(vegetable);
		
	}
	
	@GetMapping("/findvegetablebyid/{vid}")
	public Vegetable getVegetableById(@PathVariable("vid") Long vegetableId){
		return vegetableService.getVegetableById(vegetableId).get();
	}
	
	@DeleteMapping("/deletevegetable/{vid}")
	public void deleteVegetableById(@PathVariable("vid") Long vegetableId){
		 vegetableService.deleteVegetableById(vegetableId);
	}
	
	@GetMapping("/findvegetablebyname/{vname}")
	public Vegetable getVegetableByName(@PathVariable("vname") String vegetableName){
		return vegetableService.getVegetableByName(vegetableName);
	}
	
	@GetMapping("/findvegetablesbymanagerid/{mid}")
	public List<Vegetable> getVegetableByManagerId(@PathVariable("mid") Long managerId){
		return vegetableService.getVegetablesByManagerId(managerId);
	}

}
