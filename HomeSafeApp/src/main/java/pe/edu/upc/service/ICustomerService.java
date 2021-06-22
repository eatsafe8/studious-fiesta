package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Customer;

public interface ICustomerService {
	public void insert(Customer cu);

	List<Customer> list();

	public void delete(int id);

	Optional<Customer> listarID(int ID_Customer);

	List<Customer> searchDniIgnoreCase(String dniCustomer);

	List<Customer> findByDni(String dniCustomer);
}
