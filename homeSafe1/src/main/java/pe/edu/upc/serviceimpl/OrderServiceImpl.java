package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IOrderDao;
import pe.edu.upc.entity.Order;
import pe.edu.upc.service.IOrderService;

@Named
@RequestScoped
public class OrderServiceImpl implements IOrderService {

	@Inject
	private IOrderDao oDao;

	@Override
	public void insert(Order order) {
		oDao.insert(order);
	}

	@Override
	public List<Order> list() {
		return oDao.list();
	}

	@Override
	public void delete(int ID_Order) {
		oDao.delete(ID_Order);
	}

}
