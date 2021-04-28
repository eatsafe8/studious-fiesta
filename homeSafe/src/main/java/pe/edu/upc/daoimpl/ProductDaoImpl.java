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
	@PersistenceContext(unitName = "homeSafe")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Product product) {
		try {
			em.persist(product);
		} catch (Exception e) {
			System.out.println("Error en el daoImpl of Product al insertar");
			System.out.println(e.getMessage());
		}
	}
	//actualizacion
	@SuppressWarnings("unchecked")	
	@Override
	public List<Product> list() {
		List<Product> lista = new ArrayList<Product>();
		try {
			Query q = em.createQuery("from Product pro");
			lista = (List<Product>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return lista;
	}
	//...
	@Transactional
	@Override
	public void delete(int ID_Product) {
		Product product = new Product();
		try {
			product = em.getReference(Product.class, ID_Product);
			em.remove(product);
		} catch (Exception e) {
			System.out.println("Error al eliminar producto");
		}
	}

}
