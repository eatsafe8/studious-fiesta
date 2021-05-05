package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Promotion;

public interface IPromotionDao {

	public void insert(Promotion promotion);

	public List<Promotion> list();

	public void delete(int ID_Promotion);
}
