package pe.edu.upc.daoimpl;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IRestaurantDao;
import pe.edu.upc.entity.Restaurant;

public class RestaurantDaoImpl implements IRestaurantDao{
	@PersistenceContext(unitName="homeSafe")
	private EntityManager em;
	
	@Override
	@Transactional
	public void insert(Restaurant restaurant) {
		try {
			em.persist(restaurant);
		} catch (Exception e) {
			System.out.println("Error al insertar restaurante");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurant> list() {
		List<Restaurant> lista=new ArrayList<Restaurant>();
		try {
			Query q=em.createQuery("from Restaurant m");
			lista=(List<Restaurant>)q.getResultList();
			}
		catch (Exception e) {
			System.out.println("Error al listar los restaurantes");
			System.out.println(e.getLocalizedMessage());
		}
		return lista;
	}
	
	@Override
	@Transactional
	public void delete(int ID_Restaurant) {
		Restaurant restaurant= new Restaurant();
		try {
			restaurant=em.getReference(Restaurant.class, ID_Restaurant);
			em.remove(restaurant);
		} catch (Exception e) {
			System.out.println("Error al eliminar restaurante");
		}
		
	}
}
