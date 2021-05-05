package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Delivery;

public interface IDeliveryService {

	public void insert(Delivery delivery);

	public List<Delivery> list();

	public void delete(int ID_Delivery);
}
