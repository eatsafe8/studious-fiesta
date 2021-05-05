package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Roundsman;
import pe.edu.upc.entity.Vehicle;
import pe.edu.upc.service.IRoundsmanService;
import pe.edu.upc.service.IVehicleService;

@Named
@RequestScoped
public class VehicleController {
	@Inject
	private IVehicleService vhService;
	@Inject
	private IRoundsmanService rouService;

	// Attributes
	private Vehicle vehicle;
	private Roundsman roundsman;
	List<Vehicle> listaVehicles;
	List<Roundsman> listaRoundsmans;

	// Constructors
	@PostConstruct
	public void init() {
		this.roundsman = new Roundsman();
		this.vehicle = new Vehicle();
		this.listaVehicles = new ArrayList<Vehicle>();
		this.listaRoundsmans = new ArrayList<Roundsman>();
		this.listarRoundsman();
		this.listarVehicle();
	}
	
	//get an set
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Roundsman getRoundsman() {
		return roundsman;
	}

	public void setRoundsman(Roundsman roundsman) {
		this.roundsman = roundsman;
	}

	public List<Vehicle> getListaVehicles() {
		return listaVehicles;
	}

	public void setListaVehicles(List<Vehicle> listaVehicles) {
		this.listaVehicles = listaVehicles;
	}

	public List<Roundsman> getListaRoundsmans() {
		return listaRoundsmans;
	}

	public void setListaRoundsmans(List<Roundsman> listaRoundsmans) {
		this.listaRoundsmans = listaRoundsmans;
	}

	//mutates
	// Mutates
		public String nuevoVehicle() {
			this.setVehicle(new Vehicle());
			return "Vehicle.xhtml";
		}

		public void insertar() {
			try {
				vhService.insert(vehicle);
			} catch (Exception e) {
				System.out.println("Error al insertar en el controller de vehicle");
				// TODO: handle exception
			}
		}

		public void listarRoundsman() {
			try {
				listaRoundsmans = rouService.list();
			} catch (Exception e) {
				System.out.println("Error al listar en el controller de Roundsman (Vehicle)");
				// TODO: handle exception
			}
		}

		public void listarVehicle() {
			try {
				listaVehicles = vhService.list();
			} catch (Exception e) {
				System.out.println("Error al listar en el controller de Vehicle");
				// TODO: handle exception
			}
		}

		public void eliminar(Vehicle vehicle) {
			try {
				vhService.delete(vehicle.getID_Vehicle());
				this.listarVehicle();
			} catch (Exception e) {
				System.out.println("Error al eliminar en el controller de Vehicle");
				// TODO: handle exception
			}
		}

}
