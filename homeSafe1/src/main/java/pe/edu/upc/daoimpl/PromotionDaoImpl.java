package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPromotionDao;
import pe.edu.upc.entity.Promotion;

public class PromotionDaoImpl implements IPromotionDao {
	@PersistenceContext(unitName = "homeSafe")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Promotion promotion) {
		try {
			em.persist(promotion);
		} catch (Exception e) {
			System.out.println("Error al insertar en PromotionDaoImpl");
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Promotion> list() {
		List<Promotion> lista = new ArrayList<Promotion>();
		try {
			Query q = em.createQuery("from Promotion prom");
			lista = (List<Promotion>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en PromotionDaoImpl");
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int ID_Promotion) {
		Promotion promotion = new Promotion();
		try {
			promotion = em.getReference(Promotion.class, ID_Promotion);
			em.remove(promotion);
		} catch (Exception e) {
			System.out.println("Error al eliminar en PromotionDaoImpl");
			System.out.println(e.getMessage());
		}
	}

}
