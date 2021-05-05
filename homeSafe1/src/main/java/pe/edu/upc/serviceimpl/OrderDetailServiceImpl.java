package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IOrderDetailDao;
import pe.edu.upc.entity.OrderDetail;
import pe.edu.upc.service.IOrderDetailService;
@Named
@RequestScoped
public class OrderDetailServiceImpl implements IOrderDetailService{
	@Inject
	private IOrderDetailDao odDao;
	
	@Override
	public void insert(OrderDetail orderDetail) {
		odDao.insert(orderDetail);
	}

	@Override
	public List<OrderDetail> list() {
		return odDao.list();
	}

	@Override
	public void delete(int ID_OrderDetail) {
		odDao.delete(ID_OrderDetail);
	}
}
