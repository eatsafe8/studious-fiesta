package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Reservation;

public interface IReservationService {

	public void insert(Reservation reservation);
	
	public List<Reservation> list();
	
	public void delete(int ID_Reservation);
}
