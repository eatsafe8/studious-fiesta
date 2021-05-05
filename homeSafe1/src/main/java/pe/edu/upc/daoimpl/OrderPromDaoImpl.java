package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IOrderPromDao;
import pe.edu.upc.entity.OrderProm;

public class OrderPromDaoImpl implements IOrderPromDao{

	@PersistenceContext(unitName = "homeSafe")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(OrderProm orderProm) {
		try {
			em.persist(orderProm);
		} catch (Exception e) {
			System.out.println("Error al insertar en OrderPromDaoImpl");
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderProm> list() {
		List<OrderProm> lista = new ArrayList<OrderProm>();
		try {
			Query q = em.createQuery("from OrderProm op");
			lista = (List<OrderProm>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en OrderPromDaoImpl");
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int ID_OrderProm) {
		OrderProm orderProm = new OrderProm();
		try {
			orderProm = em.getReference(OrderProm.class, ID_OrderProm);
			em.remove(orderProm);
		} catch (Exception e) {
			System.out.println("Error al eliminaar en OrderPromDaoImpl");
			System.out.println(e.getMessage());
		}
	}

}
