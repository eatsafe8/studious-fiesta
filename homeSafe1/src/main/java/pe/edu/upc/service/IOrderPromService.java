package pe.edu.upc.service;

import java.util.List;
import pe.edu.upc.entity.OrderProm;

public interface IOrderPromService {

	public void insert(OrderProm orderProm);

	public List<OrderProm> list();

	public void delete(int ID_OrderProm);
}
