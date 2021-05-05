package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_OrderDetail;
	private int Quantity_OrderDetail;
	private double Discount_OrderDetail;
	@Column(name = "Notes_OrderDetail", nullable = true, length = 50)
	private String Notes_OrderDetail;
	
	@ManyToOne
	@JoinColumn(name = "ID_Product", nullable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "ID_Order", nullable = false)
	private Order order;
	
	public OrderDetail(int iD_OrderDetail, int quantity_OrderDetail, double discount_OrderDetail,
			String notes_OrderDetail, Product product, Order order) {
		super();
		ID_OrderDetail = iD_OrderDetail;
		Quantity_OrderDetail = quantity_OrderDetail;
		Discount_OrderDetail = discount_OrderDetail;
		Notes_OrderDetail = notes_OrderDetail;
		this.product = product;
		this.order = order;
	}

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getID_OrderDetail() {
		return ID_OrderDetail;
	}

	public void setID_OrderDetail(int iD_OrderDetail) {
		ID_OrderDetail = iD_OrderDetail;
	}

	public int getQuantity_OrderDetail() {
		return Quantity_OrderDetail;
	}

	public void setQuantity_OrderDetail(int quantity_OrderDetail) {
		Quantity_OrderDetail = quantity_OrderDetail;
	}

	public double getDiscount_OrderDetail() {
		return Discount_OrderDetail;
	}

	public void setDiscount_OrderDetail(double discount_OrderDetail) {
		Discount_OrderDetail = discount_OrderDetail;
	}

	public String getNotes_OrderDetail() {
		return Notes_OrderDetail;
	}

	public void setNotes_OrderDetail(String notes_OrderDetail) {
		Notes_OrderDetail = notes_OrderDetail;
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

}
