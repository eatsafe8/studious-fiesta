package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IProductDao;
import pe.edu.upc.entity.Product;

public class ProductDaoImpl implements IProductDao{

	@PersistenceContext(unitName = "EatSafeTP")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Product prod) {
		try {
			em.persist(prod);
		} catch (Exception e) {
			System.out.println("Error en el daoImpl of Product al insertar");
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")	
	@Override
	public List<Product> list() {
		List<Product> lista = new ArrayList<Product>();
		try {
			Query q = em.createQuery("from Product pr");
			lista = (List<Product>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

	@Transactional
	@Override
	public void delete(int iD_Product) {
		Product prod = new Product();
		try {
			prod = em.getReference(Product.class, iD_Product);
			em.remove(prod);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
