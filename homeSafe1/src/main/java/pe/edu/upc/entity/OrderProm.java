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
@Table(name = "OrderProm")
public class OrderProm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_OrderProm;
	
	private int Quantity_OrderProm;
	
	@Column(name = "Notes_OrderProm", nullable = false, length = 50)
	private String Notes_OrderProm;
	
	@ManyToOne
	@JoinColumn(name = "ID_Promotion", nullable = false)
	private Promotion promotion;
	
	@ManyToOne
	@JoinColumn(name = "ID_Order", nullable = false)
	private Order order;

	public OrderProm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderProm(int iD_OrderProm, int quantity_OrderProm, String notes_OrderProm, Promotion promotion,
			Order order) {
		super();
		ID_OrderProm = iD_OrderProm;
		Quantity_OrderProm = quantity_OrderProm;
		Notes_OrderProm = notes_OrderProm;
		this.promotion = promotion;
		this.order = order;
	}

	public int getID_OrderProm() {
		return ID_OrderProm;
	}

	public void setID_OrderProm(int iD_OrderProm) {
		ID_OrderProm = iD_OrderProm;
	}

	public int getQuantity_OrderProm() {
		return Quantity_OrderProm;
	}

	public void setQuantity_OrderProm(int quantity_OrderProm) {
		Quantity_OrderProm = quantity_OrderProm;
	}

	public String getNotes_OrderProm() {
		return Notes_OrderProm;
	}

	public void setNotes_OrderProm(String notes_OrderProm) {
		Notes_OrderProm = notes_OrderProm;
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
	
	
}
