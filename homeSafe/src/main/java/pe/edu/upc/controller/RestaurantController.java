package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Owner;
import pe.edu.upc.entity.Restaurant;
import pe.edu.upc.service.IOwnerService;
import pe.edu.upc.service.IRestaurantService;

@Named
@RequestScoped
public class RestaurantController {
	@Inject
	private IRestaurantService rtService;
	@Inject
	private IOwnerService owService;
	// Attributes
	private Restaurant restaurant;
	private Owner owner;
	List<Restaurant> listaRestaurants;
	List<Owner> listaOwners;

	// Constructors
	@PostConstruct
	public void init() {
		this.owner = new Owner();
		this.restaurant = new Restaurant();
		this.listaRestaurants = new ArrayList<Restaurant>();
		this.listaOwners = new ArrayList<Owner>();
		this.listarOwner();
		this.listarRestaurant();
	}

	// Mutates
	public String nuevoRestaurant() {
		this.setRestaurant(new Restaurant());
		return "Restaurant.xhtml";
	}

	public void insertar() {
		try {
			rtService.insert(restaurant);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de restaurant");
			// TODO: handle exception
		}
	}

	public void listarOwner() {
		try {
			listaOwners = owService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de owner");
			// TODO: handle exception
		}
	}

	public void listarRestaurant() {
		try {
			listaRestaurants = rtService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de restaurant");
			// TODO: handle exception
		}
	}

	public void eliminar(Restaurant restaurant) {
		try {
			rtService.delete(restaurant.getID_Restaurant());
			this.listarRestaurant();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de restaurant");
			// TODO: handle exception
		}
	}

	// get y set
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List<Restaurant> getListaRestaurants() {
		return listaRestaurants;
	}

	public void setListaRestaurants(List<Restaurant> listaRestaurants) {
		this.listaRestaurants = listaRestaurants;
	}

	public List<Owner> getListaOwners() {
		return listaOwners;
	}

	public void setListaOwners(List<Owner> listaOwners) {
		this.listaOwners = listaOwners;
	}

}
