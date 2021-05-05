package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IVehicleDao;
import pe.edu.upc.entity.Vehicle;

public class VehicleDaoImpl implements IVehicleDao{
	@PersistenceContext(unitName="homeSafe")
	private EntityManager em;
	
	@Override
	@Transactional
	public void insert(Vehicle vehicle) {
		try {
			em.persist(vehicle);
		} catch (Exception e) {
			System.out.println("Error al insertar vehicles");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> list() {
		List<Vehicle> lista=new ArrayList<Vehicle>();
		try {
			Query q=em.createQuery("from Vehicle m");
			lista=(List<Vehicle>)q.getResultList();
			}
		catch (Exception e) {
			System.out.println("Error al listar los Vehicles");
			System.out.println(e.getLocalizedMessage());
		}
		return lista;
	}
	
	@Override
	@Transactional
	public void delete(int ID_Vehicle) {
		Vehicle vehicle= new Vehicle();
		try {
			vehicle=em.getReference(Vehicle.class, ID_Vehicle);
			em.remove(vehicle);
		} catch (Exception e) {
			System.out.println("Error al eliminar Vehicle");
		}
		
	}
}
