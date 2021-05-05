package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Vehicle;

public interface IVehicleDao {
	
	public void insert(Vehicle vehicle);
	
	public List<Vehicle> list();
	
	public void delete(int ID_Vehicle);
}
