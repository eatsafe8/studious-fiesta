package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.DetailPromotion;

public interface IDetailPromotionService {
	public void insert(DetailPromotion dp);

	List<DetailPromotion> list();

	public void delete(int id);
	
	Optional<DetailPromotion> listarID(int id);
}
