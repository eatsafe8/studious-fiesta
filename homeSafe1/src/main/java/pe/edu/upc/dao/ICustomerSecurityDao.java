package pe.edu.upc.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.CustomerSecurity;

public interface ICustomerSecurityDao {
	Integer insert(CustomerSecurity customerSecurity) throws Exception;

	Integer update(CustomerSecurity customerSecurity) throws Exception;

	Integer delete(CustomerSecurity customerSecurity) throws Exception;

	List<CustomerSecurity> findAll() throws Exception;

	Optional<CustomerSecurity> findById(CustomerSecurity customerSecurity) throws Exception;

	List<CustomerSecurity> findByName(String name) throws Exception;

	Optional<CustomerSecurity> findByDni(String dni) throws Exception;
}