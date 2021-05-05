package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IDeliveryDao;
import pe.edu.upc.entity.Delivery;

public class DeliveryDaoImpl implements IDeliveryDao{

	@PersistenceContext(unitName = "homeSafe")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Delivery delivery) {
		try {
			em.persist(delivery);
		} catch (Exception e) {
			System.out.println("Error al insertar en el daoimpl de Delivery");
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Delivery> list() {
		List<Delivery> lista = new ArrayList<Delivery>();
		try {
			Query q = em.createQuery("from Delivery de");
			lista = (List<Delivery>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en el daoimpl de Delivery");
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int iD_Delivery) {
		Delivery delivery = new Delivery();
		try {
			delivery = em.getReference(Delivery.class, iD_Delivery);
			em.remove(delivery);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el daoimpl de Delivery");
			System.out.println(e.getMessage());
		}
	}
}
