package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.OrderT;

public interface IOrderService {

	public void insert(OrderT or);

	List<OrderT> list();

	public void delete(int id);
	
	Optional<OrderT> listarID(int ID_Order);
}
