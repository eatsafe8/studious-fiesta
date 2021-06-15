package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Delivery;
import pe.edu.upc.repository.DeliveryRepository;
import pe.edu.upc.service.IDeliveryService;

@Service
public class DeliveryServiceImpl implements IDeliveryService{

	@Autowired
	private DeliveryRepository dr;
	
	@Override
	public void insert(Delivery dv) {
		// TODO Auto-generated method stub
		dr.save(dv);
	}

	@Override
	public List<Delivery> list() {
		// TODO Auto-generated method stub
		return dr.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dr.deleteById(id);
	}

	@Override
	public Optional<Delivery> listarID(int ID_Delivery) {
		// TODO Auto-generated method stub
		return dr.findById(ID_Delivery);
	}

}
