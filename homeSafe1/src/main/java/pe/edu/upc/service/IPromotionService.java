package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Promotion;

public interface IPromotionService {

	public void insert(Promotion promotion);

	public List<Promotion> list();

	public void delete(int ID_Promotion);
}
