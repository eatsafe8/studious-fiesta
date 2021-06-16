package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.OrderDetail;
import pe.edu.upc.repository.OrderDetailRepository;
import pe.edu.upc.service.IOrderDetailService;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

	@Autowired
	private OrderDetailRepository odr;

	@Override
	public void insert(OrderDetail od) {
		// TODO Auto-generated method stub
		odr.save(od);
	}

	@Override
	public List<OrderDetail> list() {
		// TODO Auto-generated method stub
		return odr.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		odr.deleteById(id);
	}

	@Override
	public Optional<OrderDetail> listarID(int ID_OrderDetail) {
		// TODO Auto-generated method stub
		return odr.findById(ID_OrderDetail);
	}
}
