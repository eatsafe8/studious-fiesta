package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Order;
import pe.edu.upc.entity.OrderProm;
import pe.edu.upc.entity.Promotion;
import pe.edu.upc.service.IOrderPromService;
import pe.edu.upc.service.IOrderService;
import pe.edu.upc.service.IPromotionService;

@Named
@RequestScoped
public class OrderPromController {

	@Inject
	private IOrderPromService opService;
	@Inject
	private IPromotionService pService;
	@Inject
	private IOrderService oService;
	
	private OrderProm orderProm;
	private Promotion promotion;
	private Order order;
	List<OrderProm> listaOrderProms;
	List<Promotion> listaPromotions;
	List<Order> listaOrders;
	
	@PostConstruct
	private void init() {
		this.orderProm = new OrderProm();
		this.promotion = new Promotion();
		this.order = new Order();
		this.listaOrderProms = new ArrayList<OrderProm>();
		this.listaPromotions = new ArrayList<Promotion>();
		this.listaOrders = new ArrayList<Order>();
		this.listarOrderProm();
		this.listarPromotion();
		this.listarOrder();
	}
	
	public String nuevoOrderProm() {
		this.setOrderProm(new OrderProm());
		return "OrderProm.xhtml";
	}

	public void insertar() {
		try {
			opService.insert(orderProm);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de OrderProm");
		}
	}

	public void listarOrderProm() {
		try {
			listaOrderProms = opService.list();
		} catch (Exception e) {
			System.out.println("Error al listar las promociones en el controller de OrderProm");
		}
	}

	public void listarPromotion() {
		try {
			listaPromotions = pService.list();
		} catch (Exception e) {
			System.out.println("Error al listar los productos en el controller de OrderProm");
		}

	}

	public void listarOrder() {
		try {
			listaOrders = oService.list();
		} catch (Exception e) {
			System.out.println("Error al listar los detailPromotions en el controller de OrderProm");
		}
	}

	public void eliminar(OrderProm orderProm) {
		try {
			opService.delete(orderProm.getID_OrderProm());
			this.listarOrderProm();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de OrderProm");
		}
	}
	
	public OrderProm getOrderProm() {
		return orderProm;
	}

	public void setOrderProm(OrderProm orderProm) {
		this.orderProm = orderProm;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderProm> getListaOrderProms() {
		return listaOrderProms;
	}

	public void setListaOrderProms(List<OrderProm> listaOrderProms) {
		this.listaOrderProms = listaOrderProms;
	}

	public List<Promotion> getListaPromotions() {
		return listaPromotions;
	}

	public void setListaPromotions(List<Promotion> listaPromotions) {
		this.listaPromotions = listaPromotions;
	}

	public List<Order> getListaOrders() {
		return listaOrders;
	}

	public void setListaOrders(List<Order> listaOrders) {
		this.listaOrders = listaOrders;
	}
	
		
	
}

