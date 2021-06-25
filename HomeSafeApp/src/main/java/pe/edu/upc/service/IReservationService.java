package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Reservation;

public interface IReservationService {

	public void insert(Reservation rv);

	List<Reservation> list();

	public void delete(int id);
	
	Optional<Reservation> listarID(int ID_Reservation);
	
	
}
