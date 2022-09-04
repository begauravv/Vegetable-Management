package com.hexaware.veggies.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.veggies.entity.Manager;
import com.hexaware.veggies.repository.ManagerRepository;


@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;

	@Override
	public Manager addManager(Manager manager) {
		// TODO Auto-generated method stub
		
		return managerRepository.save(manager);
	}

	@Override
	public List<Manager> getAllManagers() {
		// TODO Auto-generated method stub
		return managerRepository.findAll();
	}

	@Override
	public Manager getManagerByUserName(String userName) {
		// TODO Auto-generated method stub
		return managerRepository.findByUserName(userName);
	}

	@Override
	public Optional<Manager> getManagerById(Long managerId) {
		// TODO Auto-generated method stub
		return managerRepository.findById(managerId);
	}

	@Override
	public Manager getManagerByEmail(String email) {
		// TODO Auto-generated method stub
		return managerRepository.findByEmail(email);
	}

	@Override
	public void deleteManagerById(	Long managerId) {
		// TODO Auto-generated method stub
		managerRepository.deleteById(managerId);
		
	}

	@Override
	public Manager updateManager(Manager manager) {
		// TODO Auto-generated method stub
	
		return managerRepository.save(manager);
	}

	@Override
	public Boolean isLogin(String email, String password) {
		// TODO Auto-generated method stub
		Manager manager = managerRepository.findByEmail (email);
        if(manager==null) throw new RuntimeException ("Email Not Exist.."+email);
        System.out.println (manager.getPassword ()+"      "+password);
        if(!manager.getPassword().equals (password)) throw new RuntimeException ("Password Not Correct..");
        return true;
	}

	@Override
	public Boolean isUserExist(Manager manager) {
		Manager manager1 = managerRepository.findByEmail (manager.getEmail ());
        if(manager1!=null) {
            throw new RuntimeException ("Email Exist..");
        }else {
            return true;
	}

}
}