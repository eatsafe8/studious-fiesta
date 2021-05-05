package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Customer;

public interface ICustomerService {

	public void insert(Customer customer);
	public List<Customer>list();
	public void delete(int iD_Customer);
	public List<Customer> findByNameCustomer(Customer customer);
	public List<Customer> findByDNICustomer(Customer customer);
	public void update(Customer customer);
}
