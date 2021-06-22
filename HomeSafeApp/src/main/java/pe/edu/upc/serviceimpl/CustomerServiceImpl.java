package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Customer;
import pe.edu.upc.repository.CustomerRepository;
import pe.edu.upc.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private CustomerRepository cR;
	
	@Override
	public void insert(Customer cu) {
		cR.save(cu);
	}
	
	@Override
	public List<Customer> list(){
		return cR.findAll();
	}
	
	@Override
	public void delete(int id) {
		cR.deleteById(id);
	}
	
	@Override
	public Optional<Customer> listarID(int ID_Customer) {
		// TODO Auto-generated method stub
		return cR.findById(ID_Customer);
	}

	@Override
	public List<Customer> searchDniIgnoreCase(String dniCustomer) {
		// TODO Auto-generated method stub
		return cR.findByDniCustomerLikeIgnoreCase(dniCustomer);
	}

	@Override
	public List<Customer> findByDni(String dniCustomer) {
		// TODO Auto-generated method stub
		return cR.findByDni(dniCustomer);
	}

}
