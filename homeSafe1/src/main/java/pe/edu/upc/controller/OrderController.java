package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Customer;
import pe.edu.upc.entity.Order;
import pe.edu.upc.entity.Restaurant;
import pe.edu.upc.service.ICustomerService;
import pe.edu.upc.service.IOrderService;
import pe.edu.upc.service.IRestaurantService;

@Named
@RequestScoped
public class OrderController {

	@Inject
	private IOrderService orService;

	@Inject
	private IRestaurantService rtService;

	@Inject
	private ICustomerService ctService;

	private Order order;
	private Restaurant restaurant;
	private Customer customer;
	private List<Order> listaOrders;
	List<Restaurant> listaRestaurants;
	List<Customer> listaCustomers;

	@PostConstruct
	private void init() {
		this.order = new Order();
		this.restaurant = new Restaurant();
		this.customer = new Customer();
		this.listaOrders = new ArrayList<Order>();
		this.listaRestaurants = new ArrayList<Restaurant>();
		this.listaCustomers = new ArrayList<Customer>();
		this.listarOrder();
		this.listarRestaurant();
		this.listarCustomer();
	}

	public String nuevoOrder() {
		this.setOrder(new Order());
		return "Order.xhtml";
	}

	public void insertar() {
		try {
			orService.insert(order);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de order");
		}
	}

	public void listarRestaurant() {
		try {
			listaRestaurants = rtService.list();
		} catch (Exception e) {
			System.out.println("Error al listar restaurants en el controller de order");
		}
	}

	public void listarCustomer() {
		try {
			listaCustomers = ctService.list();
		} catch (Exception e) {
			System.out.println("Error al listar customers en el controller de order");
		}
	}

	public void listarOrder() {
		try {
			listaOrders = orService.list();
		} catch (Exception e) {
			System.out.println("Error al listar orders en el controller de order");
		}
	}

	public void eliminar(Order order) {
		try {
			orService.delete(order.getID_Order());
			this.listarOrder();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de order");
		}
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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

	public List<Order> getListaOrders() {
		return listaOrders;
	}

	public void setListaOrders(List<Order> listaOrders) {
		this.listaOrders = listaOrders;
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
