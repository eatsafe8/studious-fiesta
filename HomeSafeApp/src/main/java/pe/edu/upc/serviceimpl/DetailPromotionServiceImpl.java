package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.DetailPromotion;
import pe.edu.upc.repository.DetailPromotionRepository;
import pe.edu.upc.service.IDetailPromotionService;

@Service
public class DetailPromotionServiceImpl implements IDetailPromotionService{
	@Autowired
	private DetailPromotionRepository dR;
	
	@Override
	public void insert(DetailPromotion or) {
		dR.save(or);
	}

	@Override
	public List<DetailPromotion> list() {
		// TODO Auto-generated method stub
		return dR.findAll();
	}

	@Override
	public void delete(int id) {
		dR.deleteById(id);
	}

}
