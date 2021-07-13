package com.customer.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.app.dto.Customerdto;
import com.customer.app.model.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public List<Customerdto> findAll() {
		return customerRepository.findAll();
	}

	public Optional<Customerdto> findById(int id) {
		return customerRepository.findById(id);
	}

	public Customerdto saveCustomerdto(Customerdto customerdto) {
		return customerRepository.save(customerdto);
	}

	public Customerdto updateCustomerdto(int id, Customerdto customerdto) {
		Customerdto updatedContact = customerRepository.findById(id).orElse(null);
		updatedContact.setName(customerdto.getName());
		updatedContact.setEmail(customerdto.getEmail());
		updatedContact.setCountry(customerdto.getCountry());
		return customerRepository.save(updatedContact);
	}

	public void deleteById(int id) {
		customerRepository.deleteById(id);
	}

}
