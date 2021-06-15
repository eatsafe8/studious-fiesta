package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Delivery;

public interface IDeliveryService {

	public void insert(Delivery dv);

	List<Delivery> list();

	public void delete(int id);
	
	Optional<Delivery> listarID(int ID_Delivery);
}
