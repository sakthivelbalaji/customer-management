package com.customer.app.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.app.dto.Customerdto;

@Repository
public interface CustomerRepository extends JpaRepository<Customerdto,Integer>{
	

	
}
