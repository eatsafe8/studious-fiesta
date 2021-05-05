package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.DetailPromotion;

public interface IDetailPromotionDao {

	public void insert(DetailPromotion detailPromotion);

	public List<DetailPromotion> list();

	public void delete(int ID_DetailPromotion);
}
