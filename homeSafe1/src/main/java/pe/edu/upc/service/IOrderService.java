package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Order;

public interface IOrderService {

	public void insert(Order order);

	public List<Order> list();

	public void delete(int ID_Order);
}
