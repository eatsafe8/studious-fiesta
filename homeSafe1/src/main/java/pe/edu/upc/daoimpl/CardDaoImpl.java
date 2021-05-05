package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ICardDao;
import pe.edu.upc.entity.Card;

public class CardDaoImpl implements ICardDao{
	@PersistenceContext(unitName="homeSafe")
	private EntityManager em;
	
	@Transactional
	public void insert(Card card) {
		try {
			em.persist(card);
		} catch (Exception e) {
			System.out.println("Error al insertar tarjeta de credito");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Card> list() {
		List<Card> lista=new ArrayList<Card>();
		try {
			Query q=em.createQuery("from Card m");
			lista=(List<Card>)q.getResultList();
			}
		catch (Exception e) {
			System.out.println("Error al listar las tarjetas de credito");
			System.out.println(e.getLocalizedMessage());
		}
		return lista;
	}
	
	@Transactional
	public void delete(int ID_Card) {
		Card card= new Card();
		try {
			card=em.getReference(Card.class, ID_Card);
			em.remove(card);
		} catch (Exception e) {
			System.out.println("Error al eliminar tarjeta de credito");
		}
		
	}
}
