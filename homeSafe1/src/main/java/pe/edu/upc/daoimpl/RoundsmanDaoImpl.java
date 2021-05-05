package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IRoundsmanDao;
import pe.edu.upc.entity.Roundsman;

public class RoundsmanDaoImpl implements IRoundsmanDao{
	@PersistenceContext(unitName="homeSafe")
	private EntityManager em;
	
	@Override
	@Transactional
	public void insert(Roundsman roundsman) {
		try {
			em.persist(roundsman);
		} catch (Exception e) {
			System.out.println("Error al insertar repartidor DaoImpl");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Roundsman> list() {
		List<Roundsman> lista=new ArrayList<Roundsman>();
		try {
			Query q=em.createQuery("from Roundsman m");
			lista=(List<Roundsman>)q.getResultList();
			}
		catch (Exception e) {
			System.out.println("Error al listar los repartidor en DaoImpl");
			System.out.println(e.getLocalizedMessage());
		}
		return lista;
	}
	
	@Override
	@Transactional
	public void delete(int ID_Roundsman) {
		Roundsman roundsman= new Roundsman();
		try {
			roundsman=em.getReference(Roundsman.class, ID_Roundsman);
			em.remove(roundsman);
		} catch (Exception e) {
			System.out.println("Error al eliminar repartidor DaoImpl");
		}
		
	}
	
	
}
