package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IDeliveryDao;
import pe.edu.upc.entity.Delivery;
import pe.edu.upc.service.IDeliveryService;

@Named
@RequestScoped
public class DeliveryServiceImpl implements IDeliveryService{

	@Inject
	private IDeliveryDao dDao;

	@Override
	public void insert(Delivery delivery) {
		dDao.insert(delivery);
	}

	@Override
	public List<Delivery> list() {
		return dDao.list();
	}

	@Override
	public void delete(int ID_Delivery) {
		dDao.delete(ID_Delivery);
	}
}
