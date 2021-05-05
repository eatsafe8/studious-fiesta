package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Restaurant;

public interface IRestaurantDao {
	public void insert(Restaurant restaurant);
	public List<Restaurant>list();
	public void delete(int ID_Restaurant);
}
