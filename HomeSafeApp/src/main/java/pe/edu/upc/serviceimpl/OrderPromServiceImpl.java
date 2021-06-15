package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.OrderProm;
import pe.edu.upc.repository.OrderPromRepository;
import pe.edu.upc.service.IOrderPromService;

@Service
public class OrderPromServiceImpl implements IOrderPromService{

	@Autowired
	private OrderPromRepository opr;

	@Override
	public void insert(OrderProm op) {
		// TODO Auto-generated method stub
		opr.save(op);
	}

	@Override
	public List<OrderProm> list() {
		// TODO Auto-generated method stub
		return opr.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		opr.deleteById(id);;
	}

	@Override
	public Optional<OrderProm> listarID(int ID_OrderProm) {
		// TODO Auto-generated method stub
		return opr.findById(ID_OrderProm);
	}
}
