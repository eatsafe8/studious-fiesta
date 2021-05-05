package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Reservation;

public interface IReservationDao {

	public void insert(Reservation reservation);

	public List<Reservation> list();

	public void delete(int ID_Reservation);
}
