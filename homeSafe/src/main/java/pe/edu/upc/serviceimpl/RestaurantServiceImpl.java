package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IRestaurantDao;
import pe.edu.upc.entity.Restaurant;
import pe.edu.upc.service.IRestaurantService;

@Named
@RequestScoped
public class RestaurantServiceImpl implements IRestaurantService {
	@Inject
	private IRestaurantDao reDao;

	public void insert(Restaurant restaurant) {
		// TODO Auto-generated method stub
		reDao.insert(restaurant);
	}

	public List<Restaurant> list() {

		return reDao.list();
	}

	public void delete(int ID_Restaurant) {
		reDao.delete(ID_Restaurant);

	}
}
