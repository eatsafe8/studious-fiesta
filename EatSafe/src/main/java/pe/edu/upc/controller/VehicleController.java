package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Vehicle;
import pe.edu.upc.service.IVehicleService;

@Named
@RequestScoped
public class VehicleController {
	@Inject
	private IVehicleService vService;

	// Atributos
	private Vehicle vehicle;
	List<Vehicle> listaVehiculos;

	// Constructores
	@PostConstruct
	public void init() {
		this.listaVehiculos = new ArrayList<Vehicle>();
		this.vehicle = new Vehicle();
		this.listar();
	}

	// Métodos
	public String nuevoVehiculo() {
		this.setVehicle(new Vehicle());
		return "vehicle.xhtml";
	}

	public void insert() {
		try {
			vService.insert(vehicle);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de Vehicle");
		}
	}

	public void listar() {
		try {
			listaVehiculos = vService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de Vehicle");
		}
	}

	public void eliminar(Vehicle vehi) {
		try {
			vService.delete(vehi.getID_Vehicle());
			this.listar();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de Vehicle");
		}
	}

	// Gets y Sets
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<Vehicle> getListaVehiculos() {
		return listaVehiculos;
	}

	public void setListaVehiculos(List<Vehicle> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}

}
