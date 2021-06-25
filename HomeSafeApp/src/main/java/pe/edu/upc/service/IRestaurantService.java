package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Restaurant;

public interface IRestaurantService {
	public void insert(Restaurant rt);

	List<Restaurant> list();

	public void delete(int id);
	
	Optional<Restaurant> listarID(int ID_Restaurant);
	
	List<String[]> MontoRestuaranteFiestasPatrias();
}
