package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Restaurant;
import pe.edu.upc.repository.RestaurantRepository;
import pe.edu.upc.service.IRestaurantService;

@Service
public class RestaurantServiceImpl implements IRestaurantService{
	@Autowired
	private RestaurantRepository rR;
	
	@Override
	public void insert(Restaurant rt) {
		rR.save(rt);
	}
	
	@Override
	public List<Restaurant> list(){
		return rR.findAll();
	}
	
	@Override
	public void delete(int id) {
		rR.deleteById(id);
	}
	
	@Override
	public Optional<Restaurant> listarID(int ID_Restaurant) {
		// TODO Auto-generated method stub
		return rR.findById(ID_Restaurant);
	}

	@Override
	public List<String[]> MontoRestuaranteFiestasPatrias() {
		// TODO Auto-generated method stub
		return rR.montoxFiestasPatrias();
	}
}
