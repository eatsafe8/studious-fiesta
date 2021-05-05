package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Customer;
import pe.edu.upc.entity.Reservation;
import pe.edu.upc.entity.Restaurant;
import pe.edu.upc.service.ICustomerService;
import pe.edu.upc.service.IReservationService;
import pe.edu.upc.service.IRestaurantService;

@Named
@RequestScoped
public class ReservationController {
	@Inject
	private IReservationService reService;

	@Inject
	private IRestaurantService rtService;

	@Inject
	private ICustomerService ctService;

	private Reservation reservation;
	private Restaurant restaurant;
	private Customer customer;
	List<Reservation> listaReservations;
	List<Restaurant> listaRestaurants;
	List<Customer> listaCustomers;

	@PostConstruct
	private void init() {
		this.reservation = new Reservation();
		this.restaurant = new Restaurant();
		this.customer = new Customer();
		this.listaReservations = new ArrayList<Reservation>();
		this.listaRestaurants = new ArrayList<Restaurant>();
		this.listaCustomers = new ArrayList<Customer>();
		this.listarReservation();
		this.listarRestaurant();
		this.listarCustomer();
	}

	public String nuevoReservation() {
		this.setReservation(new Reservation());
		return "Reservation.xhtml";
	}

	public void insertar() {
		try {
			reService.insert(reservation);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de reservation");
		}
	}

	public void listarRestaurant() {
		try {
			listaRestaurants = rtService.list();
		} catch (Exception e) {
			System.out.println("Error al listar restaurants en el controller de reservation");
		}
	}

	public void listarCustomer() {
		try {
			listaCustomers = ctService.list();
		} catch (Exception e) {
			System.out.println("Error al listar customers en el controller de reservation");
		}
	}

	public void listarReservation() {
		try {
			listaReservations = reService.list();
		} catch (Exception e) {
			System.out.println("Error al listar reservations en el controller de reservation");
		}
	}

	public void eliminar(Reservation reservation) {
		try {
			reService.delete(reservation.getID_Reservation());
			this.listarReservation();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de reservation");
		}
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Reservation> getListaReservations() {
		return listaReservations;
	}

	public void setListaReservations(List<Reservation> listaReservations) {
		this.listaReservations = listaReservations;
	}

	public List<Restaurant> getListaRestaurants() {
		return listaRestaurants;
	}

	public void setListaRestaurants(List<Restaurant> listaRestaurants) {
		this.listaRestaurants = listaRestaurants;
	}

	public List<Customer> getListaCustomers() {
		return listaCustomers;
	}

	public void setListaCustomers(List<Customer> listaCustomers) {
		this.listaCustomers = listaCustomers;
	}
}
