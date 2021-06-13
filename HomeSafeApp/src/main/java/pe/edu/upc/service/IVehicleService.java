package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Vehicle;

public interface IVehicleService {

	public void insert(Vehicle vh);

	List<Vehicle> list();

	public void delete(int id);
	
	Optional<Vehicle> listarID(int ID_vehicle);
}
