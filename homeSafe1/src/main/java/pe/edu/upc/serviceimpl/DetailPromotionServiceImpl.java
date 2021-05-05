package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IDetailPromotionDao;
import pe.edu.upc.entity.DetailPromotion;
import pe.edu.upc.service.IDetailPromotionService;

@Named
@RequestScoped
public class DetailPromotionServiceImpl implements IDetailPromotionService {

	@Inject
	private IDetailPromotionDao dpDao;

	@Override
	public void insert(DetailPromotion detailPromotion) {
		dpDao.insert(detailPromotion);
	}

	@Override
	public List<DetailPromotion> list() {
		return dpDao.list();
	}

	@Override
	public void delete(int ID_DetailPromotion) {
		dpDao.delete(ID_DetailPromotion);
	}

}
