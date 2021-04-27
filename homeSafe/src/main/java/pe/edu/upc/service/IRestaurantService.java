package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Restaurant;

public interface IRestaurantService {
	public void insert(Restaurant restaurant);
	public List<Restaurant>list();
	public void delete(int ID_Restaurant);
}
