package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Delivery;

public interface IDeliveryDao {

	public void insert(Delivery delivery);
	public List<Delivery>list();
	public void delete(int iD_Delivery);
}
