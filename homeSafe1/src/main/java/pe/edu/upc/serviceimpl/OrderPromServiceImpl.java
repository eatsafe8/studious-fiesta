package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IOrderPromDao;
import pe.edu.upc.entity.OrderProm;
import pe.edu.upc.service.IOrderPromService;

@Named
@RequestScoped
public class OrderPromServiceImpl implements IOrderPromService{

	@Inject
	private IOrderPromDao opDao;
	
	@Override
	public void insert(OrderProm orderProm) {
		opDao.insert(orderProm);
	}

	@Override
	public List<OrderProm> list() {
		return opDao.list();
	}

	@Override
	public void delete(int ID_OrderProm) {
		opDao.delete(ID_OrderProm);
	}

}
