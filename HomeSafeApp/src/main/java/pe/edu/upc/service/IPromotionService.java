package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Promotion;

public interface IPromotionService {
	public void insert(Promotion pr);

	List<Promotion> list();

	public void delete(int id);
}
