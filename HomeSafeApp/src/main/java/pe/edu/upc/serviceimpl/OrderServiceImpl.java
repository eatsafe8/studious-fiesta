package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.OrderT;
import pe.edu.upc.repository.OrderRepository;
import pe.edu.upc.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService{

	
	@Autowired
	private OrderRepository oR;
	
	@Override
	public void insert(OrderT or) {
		oR.save(or);
	}

	@Override
	public List<OrderT> list() {
		// TODO Auto-generated method stub
		return oR.findAll();
	}

	@Override
	public void delete(int id) {
		oR.deleteById(id);
	}

	@Override
	public Optional<OrderT> listarID(int ID_Order) {
		// TODO Auto-generated method stub
		return oR.findById(ID_Order);
	}

}
