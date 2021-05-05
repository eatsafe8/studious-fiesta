package pe.edu.upc.daoimpl;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ICustomerDao;
import pe.edu.upc.entity.Customer;

public class CustomerDaoImpl implements ICustomerDao{

	@PersistenceContext(unitName = "homeSafe")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Customer customer) {
		try {
			em.persist(customer);
		} catch (Exception e) {
			System.out.println("Error al insertar cliente");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> list() {
		List<Customer> lista=new ArrayList<Customer>();
		try {
			Query q=em.createQuery("from Customer m");
			lista=(List<Customer>)q.getResultList();
			}
		catch (Exception e) {
			System.out.println("Error al listar los clientes");
			System.out.println(e.getLocalizedMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int iD_Customer) {
		Customer customer= new Customer();
		try {
			customer=em.getReference(Customer.class, iD_Customer);
			em.remove(customer);
		} catch (Exception e) {
			System.out.println("Error al eliminar cliente");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findByNameCustomer(Customer customer) {
		List<Customer> lista = new ArrayList<Customer>();
		try {
			Query q = em.createQuery("from Customer m where m.LastName_Customer like ?1");
			q.setParameter(1, "%" + customer.getLastName_Customer() + "%");
			lista = (List<Customer>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findByDNICustomer(Customer customer) {
		List<Customer> lista = new ArrayList<Customer>();
		try {
			Query q = em.createQuery("from Customer m where m.DNI_Customer like ?1");
			
			q.setParameter(1, "%" + customer.getDNI_Customer() + "%");
			lista = (List<Customer>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional // modificaciones en las tablas
    @Override 
    public void update(Customer customer) {
        try {
            em.merge(customer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
