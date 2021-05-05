package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Order;
import pe.edu.upc.entity.OrderDetail;
import pe.edu.upc.entity.Product;
import pe.edu.upc.service.IOrderDetailService;
import pe.edu.upc.service.IOrderService;
import pe.edu.upc.service.IProductService;

@Named
@RequestScoped
public class OrderDetailController {
	@Inject
	private IOrderDetailService odService;
	@Inject
	private IProductService proService;
	@Inject
	private IOrderService oService;
	

	//Attributes
	private OrderDetail orderDetail;
	private Product product;
	private Order order;
	List<OrderDetail> listaOrderDetails;
	List<Product> listaProducts;
	List<Order> listaOrders;
	
	@PostConstruct
	private void init() {
		this.orderDetail = new OrderDetail();
		this.product = new Product();
		this.order = new Order();
		this.listaOrderDetails = new ArrayList<OrderDetail>();
		this.listaProducts = new ArrayList<Product>();
		this.listaOrders = new ArrayList<Order>();
		this.listarOrderDetail();
		this.listarProduct();
		this.listarOrder();
	}
	
	public String nuevoOrderDetail() {
		this.setOrderDetail(new OrderDetail());
		return "OrderDetail.xhtml";
	}

	public void insertar() {
		try {
			odService.insert(orderDetail);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de OrderDetail");
		}
	}

	public void listarOrderDetail() {
		try {
			listaOrderDetails = odService.list();
		} catch (Exception e) {
			System.out.println("Error al listar las promociones en el controller de OrderDetail");
		}
	}

	public void listarProduct() {
		try {
			listaProducts = proService.list();
		} catch (Exception e) {
			System.out.println("Error al listar los productos en el controller de OrderDetail");
		}

	}

	public void listarOrder() {
		try {
			listaOrders = oService.list();
		} catch (Exception e) {
			System.out.println("Error al listar las orders en el controller de OrderDetail");
		}
	}

	public void eliminar(OrderDetail orderDetail) {
		try {
			odService.delete(orderDetail.getID_OrderDetail());
			this.listarOrderDetail();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de OrderDetail");
		}
	}
	
	
	
	//get an set
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderDetail> getListaOrderDetails() {
		return listaOrderDetails;
	}

	public void setListaOrderDetails(List<OrderDetail> listaOrderDetails) {
		this.listaOrderDetails = listaOrderDetails;
	}

	public List<Product> getListaProducts() {
		return listaProducts;
	}

	public void setListaProducts(List<Product> listaProducts) {
		this.listaProducts = listaProducts;
	}

	public List<Order> getListaOrders() {
		return listaOrders;
	}

	public void setListaOrders(List<Order> listaOrders) {
		this.listaOrders = listaOrders;
	}
	

	
}
