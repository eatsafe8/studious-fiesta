package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IPromotionDao;
import pe.edu.upc.entity.Promotion;
import pe.edu.upc.service.IPromotionService;

@Named
@RequestScoped
public class PromotionServiceImpl implements IPromotionService {

	@Inject
	private IPromotionDao prDao;
	
	@Override
	public void insert(Promotion promotion) {
		prDao.insert(promotion);
	}

	@Override
	public List<Promotion> list() {
		return prDao.list();
	}

	@Override
	public void delete(int ID_Promotion) {
		prDao.delete(ID_Promotion);
	}

}
