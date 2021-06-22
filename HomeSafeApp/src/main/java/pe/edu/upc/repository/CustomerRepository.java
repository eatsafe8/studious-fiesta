package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Customer;
import pe.edu.upc.entities.Product;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("select p from Customer p where p.dniCustomer like %:dniCustomer%")
	public List<Customer> findByDni(String dniCustomer);
	
	public List<Customer> findByDniCustomerLikeIgnoreCase(String dniCustomer);
	
}
