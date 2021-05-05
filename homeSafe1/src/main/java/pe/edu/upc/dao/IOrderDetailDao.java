package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.OrderDetail;

public interface IOrderDetailDao {
	
	public void insert(OrderDetail orderDetail);

	public List<OrderDetail> list();

	public void delete(int ID_OrderDetail);
}
