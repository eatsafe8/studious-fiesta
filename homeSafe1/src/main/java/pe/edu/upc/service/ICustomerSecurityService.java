package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.CustomerSecurity;

public interface ICustomerSecurityService {
	Integer insert(CustomerSecurity customerSecurity) throws Exception;

	Integer update(CustomerSecurity customerSecurity) throws Exception;

	Integer delete(CustomerSecurity customerSecurity) throws Exception;

	List<CustomerSecurity> getAll() throws Exception;

	Optional<CustomerSecurity> getOne(CustomerSecurity customerSecurity) throws Exception;

	List<CustomerSecurity> findCustomerSecurityByName(String name) throws Exception;

	Optional<CustomerSecurity> findCustomerSecurityByDni(String dni) throws Exception;

}
