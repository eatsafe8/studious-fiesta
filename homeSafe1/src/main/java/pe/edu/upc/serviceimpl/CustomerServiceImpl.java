package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ICustomerDao;
import pe.edu.upc.entity.Customer;
import pe.edu.upc.service.ICustomerService;

@Named
@RequestScoped
public class CustomerServiceImpl implements ICustomerService{

	@Inject
	private ICustomerDao cDao;
	@Override
	public void insert(Customer customer) {
		cDao.insert(customer);
	}

	@Override
	public List<Customer> list() {
		// TODO Auto-generated method stub
		return cDao.list();
	}

	@Override
	public void delete(int iD_Customer) {
		cDao.delete(iD_Customer);
	}

	@Override
	public List<Customer> findByNameCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return cDao.findByNameCustomer(customer);
	}
	@Override
	public List<Customer> findByDNICustomer(Customer customer) {
		// TODO Auto-generated method stub
		return cDao.findByDNICustomer(customer);
	}
	
	@Override
    public void update(Customer customer) {
        cDao.update(customer);
    }
	
}
