package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.DetailPromotion;

public interface IDetailPromotionService {

	public void insert(DetailPromotion detailPromotion);

	public List<DetailPromotion> list();

	public void delete(int ID_DetailPromotion);
}
