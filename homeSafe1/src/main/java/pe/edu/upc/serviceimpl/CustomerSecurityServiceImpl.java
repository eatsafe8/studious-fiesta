package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ICustomerSecurityDao;
import pe.edu.upc.entity.CustomerSecurity;
import pe.edu.upc.service.ICustomerSecurityService;

@Named
public class CustomerSecurityServiceImpl implements ICustomerSecurityService, Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private ICustomerSecurityDao cD;

	@Transactional
	@Override
	public Integer insert(CustomerSecurity t) throws Exception {
		return cD.insert(t);
	}

	@Transactional
	@Override
	public Integer update(CustomerSecurity t) throws Exception {
		return cD.update(t);
	}

	@Transactional
	@Override
	public Integer delete(CustomerSecurity t) throws Exception {
		return cD.delete(t);
	}

	@Override
	public List<CustomerSecurity> getAll() throws Exception {
		return cD.findAll();
	}

	@Override
	public Optional<CustomerSecurity> getOne(CustomerSecurity t) throws Exception {
		return cD.findById(t);
	}

	@Override
	public List<CustomerSecurity> findCustomerSecurityByName(String name) throws Exception {
		return cD.findByName(name);
	}

	@Override
	public Optional<CustomerSecurity> findCustomerSecurityByDni(String dni) throws Exception {
		return cD.findByDni(dni);
	}
}
