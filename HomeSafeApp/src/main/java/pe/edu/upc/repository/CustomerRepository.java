package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("select p from Customer p where p.dniCustomer like %:dniCustomer%")
	public List<Customer> findByDni(String dniCustomer);
	
	public List<Customer> findByDniCustomerLikeIgnoreCase(String dniCustomer);
	
	@Query(value = "select c.first_name_customer, c.last_name_customer, sum(o.price_order*(1-o.discount_price)) as TotalDineroGastado\r\n"
			+ "	from Customer c inner join OrderT o on c.ID_Customer=o.ID_Customer\r\n"
			+ "	group by c.first_name_customer, c.last_name_customer", nativeQuery = true)
	public List<String[]> cusXpriceorder();
	
	
}
