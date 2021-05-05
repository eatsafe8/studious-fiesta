package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IVehicleDao;
import pe.edu.upc.entity.Vehicle;
import pe.edu.upc.service.IVehicleService;

@Named
@RequestScoped
public class VehicleServiceImpl implements IVehicleService{
	@Inject
	private IVehicleDao vehDao;

	public void insert(Vehicle vehicle) {
		vehDao.insert(vehicle);
	}

	public List<Vehicle> list() {
	
		return vehDao.list();
	}

	public void delete(int ID_Vehicle) {
		vehDao.delete(ID_Vehicle);
	
	}
}
