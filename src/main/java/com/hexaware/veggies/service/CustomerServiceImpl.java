package com.hexaware.veggies.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.veggies.entity.Customer;
import com.hexaware.veggies.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerByUserName(String userName) {
		// TODO Auto-generated method stub
		return customerRepository.findByUserName(userName);
	}

	@Override
	public Optional<Customer> getCustomerById(Long customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId);
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return customerRepository.findByEmail(email);
	}

	@Override
	public void deleteCustomerById(	Long customerId) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(customerId);
		
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
	
		return customerRepository.save(customer);
	}

	@Override
	public Boolean isLogin(String email, String password) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findByEmail (email);
        if(customer==null) throw new RuntimeException ("Email Not Exist.."+email);
        System.out.println (customer.getPassword ()+"      "+password);
        if(!customer.getPassword().equals (password)) throw new RuntimeException ("Password Not Correct..");
        return true;
	}

	@Override
	public Boolean isUserExist(Customer customer) {
		Customer customer1 = customerRepository.findByEmail (customer.getEmail ());
        if(customer1!=null) {
            throw new RuntimeException ("Email Exist..");
        }else {
            return true;
	}

}
}