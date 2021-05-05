package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Order;

public interface IOrderDao {
	
	public void insert(Order order);

	public List<Order> list();

	public void delete(int ID_Order);
}
