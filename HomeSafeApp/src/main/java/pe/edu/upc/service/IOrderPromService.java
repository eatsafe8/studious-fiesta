package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.OrderProm;

public interface IOrderPromService {

	public void insert(OrderProm op);

	List<OrderProm> list();

	public void delete(int id);
	
	Optional<OrderProm> listarID(int ID_OrderProm);
}
