package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.OrderDetail;

public interface IOrderDetailService {
	public void insert(OrderDetail orderDetail);

	public List<OrderDetail> list();

	public void delete(int ID_OrderDetail);
}
