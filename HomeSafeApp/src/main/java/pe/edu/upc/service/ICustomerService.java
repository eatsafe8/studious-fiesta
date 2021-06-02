package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Customer;

public interface ICustomerService {
	public void insert(Customer cu);

	List<Customer> list();

	public void delete(int id);
}
