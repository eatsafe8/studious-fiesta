package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.OrderDetail;

public interface IOrderDetailService {

	public void insert(OrderDetail od);

	List<OrderDetail> list();

	public void delete(int id);
	
	Optional<OrderDetail> listarID(int ID_OrderDetail);

}
