package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IDetailPromotionDao;
import pe.edu.upc.entity.DetailPromotion;

public class DetailPromotionDaoImpl implements IDetailPromotionDao {
	@PersistenceContext(unitName = "homeSafe")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(DetailPromotion detailPromotion) {
		try {
			em.persist(detailPromotion);
		} catch (Exception e) {
			System.out.println("Error al insertar en DetailPromotionDaoImpl");
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetailPromotion> list() {
		List<DetailPromotion> lista = new ArrayList<DetailPromotion>();
		try {
			Query q = em.createQuery("from DetailPromotion dp");
			lista = (List<DetailPromotion>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en DetailPromotionDaoImpl");
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int ID_DetailPromotion) {
		DetailPromotion detailPromotion = new DetailPromotion();
		try {
			detailPromotion = em.getReference(DetailPromotion.class, ID_DetailPromotion);
			em.remove(detailPromotion);
		} catch (Exception e) {
			System.out.println("Error al eliminaar en DetailPromotionDaoImpl");
			System.out.println(e.getMessage());
		}
	}

}
