package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IOwnerDao;
import pe.edu.upc.entity.Owner;

public class OwnerDaoImpl implements IOwnerDao{
	@PersistenceContext(unitName="homeSafe")
	private EntityManager em;
	
	@Transactional
	public void insert(Owner owner) {
		try {
			em.persist(owner);
		} catch (Exception e) {
			System.out.println("Error al insertar dueño");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Owner> list() {
		List<Owner> lista=new ArrayList<Owner>();
		try {
			Query q=em.createQuery("from Owner m");
			lista=(List<Owner>)q.getResultList();
			}
		catch (Exception e) {
			System.out.println("Error al listar los dueños");
			System.out.println(e.getLocalizedMessage());
		}
		return lista;
	}
	
	@Transactional
	public void delete(int ID_Owner) {
		Owner owner= new Owner();
		try {
			owner=em.getReference(Owner.class, ID_Owner);
			em.remove(owner);
		} catch (Exception e) {
			System.out.println("Error al eliminar dueño");
		}
		
	}
}
