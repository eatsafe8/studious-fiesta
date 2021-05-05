package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Customer;
import pe.edu.upc.entity.Delivery;
import pe.edu.upc.entity.Order;
import pe.edu.upc.entity.Roundsman;
import pe.edu.upc.service.ICustomerService;
import pe.edu.upc.service.IDeliveryService;
import pe.edu.upc.service.IOrderService;
import pe.edu.upc.service.IRoundsmanService;

@Named
@RequestScoped
public class DeliveryController {

	@Inject
	private IDeliveryService deService;
	@Inject
	private ICustomerService cuService;
	@Inject
	private IRoundsmanService roService;
	@Inject
	private IOrderService orService;
	
	private Delivery delivery;
	private Customer customer;
	private Roundsman roundsman;
	private Order order;
	
	List<Delivery> listaDeliveries;
	List<Customer> listaCustomers;
	List<Roundsman> listaRoundsmans;
	List<Order> listaOrders;
	
	@PostConstruct
	private void init() {
		this.delivery = new Delivery();
		this.roundsman = new Roundsman();
		this.customer = new Customer();
		this.order = new Order();
		this.listaDeliveries = new ArrayList<Delivery>();
		this.listaCustomers = new ArrayList<Customer>();
		this.listaRoundsmans = new ArrayList<Roundsman>();
		this.listaOrders = new ArrayList<Order>();
		this.listarDelivery();
		this.listarCustomer();
		this.listarRoundsman();
		this.listarOrder();
	}
	public String nuevoDelivery() {
		this.setDelivery(new Delivery());
		return "Delivery.xhtml";
	}
	
	public void insertar() {
		try {
			deService.insert(delivery);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de delivery");
		}
	}
	public void listarDelivery() {
		try {
			listaDeliveries = deService.list();
		} catch (Exception e) {
			System.out.println("Error al listar restaurants en el controller de delivery");
		}
	}
	public void listarCustomer() {
		try {
			listaCustomers= cuService.list();
		} catch (Exception e) {
			System.out.println("Error al listar restaurants en el controller de customer");
		}
	}
	public void listarRoundsman() {
		try {
			listaRoundsmans= roService.list();
		} catch (Exception e) {
			System.out.println("Error al listar restaurants en el controller de roundsman");
		}
	}
	public void listarOrder() {
		try {
			listaOrders= orService.list();
		} catch (Exception e) {
			System.out.println("Error al listar restaurants en el controller de order");
		}
	}
	public void eliminar(Delivery delivery) {
		try {
			deService.delete(delivery.getID_Delivery());
			this.listarDelivery();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de delivery");
		}
	}
	
	
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Roundsman getRoundsman() {
		return roundsman;
	}
	public void setRoundsman(Roundsman roundsman) {
		this.roundsman = roundsman;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Delivery> getListaDeliveries() {
		return listaDeliveries;
	}
	public void setListaDeliveries(List<Delivery> listaDeliveries) {
		this.listaDeliveries = listaDeliveries;
	}
	public List<Customer> getListaCustomers() {
		return listaCustomers;
	}
	public void setListaCustomers(List<Customer> listaCustomers) {
		this.listaCustomers = listaCustomers;
	}
	public List<Roundsman> getListaRoundsmans() {
		return listaRoundsmans;
	}
	public void setListaRoundsmans(List<Roundsman> listaRoundsmans) {
		this.listaRoundsmans = listaRoundsmans;
	}
	public List<Order> getListaOrders() {
		return listaOrders;
	}
	public void setListaOrders(List<Order> listaOrders) {
		this.listaOrders = listaOrders;
	}
	
}
