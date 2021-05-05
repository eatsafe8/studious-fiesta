package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pe.edu.upc.dao.ICustomerSecurityDao;
import pe.edu.upc.entity.CustomerSecurity;

@Named
public class CustomerSecurityDaoImpl implements ICustomerSecurityDao, Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "homeSafe")
	private EntityManager em;

	public Integer insert(CustomerSecurity t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	public Integer update(CustomerSecurity t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	public Integer delete(CustomerSecurity t) throws Exception {
		em.remove(t);
		return 1;
	}

	@SuppressWarnings("unchecked")
	public List<CustomerSecurity> findAll() throws Exception {
		List<CustomerSecurity> customerSecuritys = new ArrayList<CustomerSecurity>();

		Query q = em.createQuery("SELECT c FROM CustomerSecurity c");
		customerSecuritys = (List<CustomerSecurity>) q.getResultList();
		return customerSecuritys;
	}

	@SuppressWarnings("unchecked")
	public Optional<CustomerSecurity> findById(CustomerSecurity t) throws Exception {

		CustomerSecurity customerSecurityFound = new CustomerSecurity();

		List<CustomerSecurity> customerSecuritys = new ArrayList<CustomerSecurity>();
		Query q = em.createQuery("FROM CustomerSecurity c where c.id = ?1");
		q.setParameter(1, t.getId());

		customerSecuritys = (List<CustomerSecurity>) q.getResultList();

		if (customerSecuritys != null && !customerSecuritys.isEmpty()) {
			customerSecurityFound = customerSecuritys.get(0);
		}

		return Optional.of(customerSecurityFound);

	}

	public List<CustomerSecurity> findByName(String name) throws Exception {
		return em.createQuery("from CustomerSecurity where name like :name", CustomerSecurity.class)
				.setParameter("name", "%" + name + "%").getResultList();
	}

	public Optional<CustomerSecurity> findByDni(String dni) throws Exception {
		CustomerSecurity customerSecurity;
		TypedQuery<CustomerSecurity> customerSecurityExist = em.createQuery("Select c from CustomerSecurity c  where c.dni =:dni",
				CustomerSecurity.class);
		customerSecurityExist.setParameter("dni", dni);
		customerSecurity = customerSecurityExist.getSingleResult();

		return Optional.of(customerSecurity);
	}

}