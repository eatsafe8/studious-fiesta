package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IReservationDao;
import pe.edu.upc.entity.Reservation;

public class ReservationDaoImpl implements IReservationDao {
	@PersistenceContext(unitName = "homeSafe")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Reservation reservation) {
		try {
			em.persist(reservation);
		} catch (Exception e) {
			System.out.println("Error al insertar en el daoimpl de Reservation");
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> list() {
		List<Reservation> lista = new ArrayList<Reservation>();
		try {
			Query q = em.createQuery("from Reservation rsr");
			lista = (List<Reservation>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en el daoimpl de Reservation");
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int ID_Reservation) {
		Reservation reservation = new Reservation();
		try {
			reservation = em.getReference(Reservation.class, ID_Reservation);
			em.remove(reservation);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el daoimpl de Reservation");
			System.out.println(e.getMessage());
		}
	}

}
