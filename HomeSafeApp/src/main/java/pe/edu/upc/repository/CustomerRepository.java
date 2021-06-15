package pe.edu.upc.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	//@Query("select c from Customer c where c.LastName_Customer like %:LastName_Customer%")
	//public List<Customer> findByName(String lastnameCustomer);
	
	//public List<Customer> findBynameCustomerLikeIgnoreCase(String name);
}
