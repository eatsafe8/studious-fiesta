package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.OrderProm;

public interface IOrderPromDao {

	public void insert(OrderProm orderProm);

	public List<OrderProm> list();

	public void delete(int ID_OrderProm);
}
