package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IOrderDao;
import pe.edu.upc.entity.Order;

public class OrderDaoImpl implements IOrderDao {
	@PersistenceContext(unitName = "homeSafe")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Order order) {
		try {
			em.persist(order);
		} catch (Exception e) {
			System.out.println("Error al insertar en OrderDaoImpl");
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> list() {
		List<Order> lista = new ArrayList<Order>();
		try {
			Query q = em.createQuery("from Order m");
			lista = (List<Order>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en OrderDaoImpl");
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int ID_Order) {
		Order order = new Order();
		try {
			order = em.getReference(Order.class, ID_Order);
			em.remove(order);
		} catch (Exception e) {
			System.out.println("Error al eliminar en OrderDaoImpl");
			System.out.println(e.getMessage());
		}
	}

}
