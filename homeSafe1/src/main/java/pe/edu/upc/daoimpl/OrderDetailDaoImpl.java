package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IOrderDetailDao;
import pe.edu.upc.entity.OrderDetail;

public class OrderDetailDaoImpl implements IOrderDetailDao{
	@PersistenceContext(unitName = "homeSafe")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(OrderDetail orderDetail) {
		try {
			em.persist(orderDetail);
		} catch (Exception e) {
			System.out.println("Error al insertar en orderDetailDaoImpl");
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> list() {
		List<OrderDetail> lista = new ArrayList<OrderDetail>();
		try {
			Query q = em.createQuery("from OrderDetail od");
			lista = (List<OrderDetail>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en OrderDetailDaoImpl");
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int ID_OrderDetail) {
		OrderDetail orderDetail = new OrderDetail();
		try {
			orderDetail = em.getReference(OrderDetail.class, ID_OrderDetail);
			em.remove(orderDetail);
		} catch (Exception e) {
			System.out.println("Error al eliminaar en OrderDetailDaoImpl");
			System.out.println(e.getMessage());
		}
	}

}
