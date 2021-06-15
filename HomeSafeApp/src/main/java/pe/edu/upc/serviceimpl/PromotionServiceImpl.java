package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Promotion;
import pe.edu.upc.repository.PromotionRepository;
import pe.edu.upc.service.IPromotionService;

@Service
public class PromotionServiceImpl implements IPromotionService{
	@Autowired
	private PromotionRepository pR;
	
	@Override
	public void insert(Promotion pr) {
		// TODO Auto-generated method stub
		pR.save(pr);
	}

	@Override
	public List<Promotion> list() {
		// TODO Auto-generated method stub
		return pR.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		pR.deleteById(id);
	}

}
