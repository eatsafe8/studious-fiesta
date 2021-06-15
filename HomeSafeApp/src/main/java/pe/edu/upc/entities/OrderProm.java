package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "OrderProm")
public class OrderProm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_OrderProm;
	
	@ManyToOne
	@JoinColumn(name = "ID_Order", nullable = false)
	private OrderT ID_Order;
	
	@ManyToOne
	@JoinColumn(name = "ID_Promotion", nullable = false)
	private Promotion ID_Promotion;
	
	@Pattern(regexp = "[0-9]*", message = "El campo CANTIDAD solo acepta numeros")
	@Size(min = 1, max = 2, message = "El campo CANTIDAD esta en el rango [1;99]")
	@NotEmpty(message = "Ingrese CANTIDAD")
	@Column(name = "Quantity_OrderProm", nullable = false, length=20)
	private String Quantity_OrderProm; 
	
	@Column(name = "Notes_OrderProm", length=50)
	private String Notes_OrderProm;
	
	public OrderProm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderProm(int iD_OrderProm, OrderT iD_Order, Promotion iD_Promotion, String quantity_OrderProm,
			String notes_OrderProm) {
		super();
		ID_OrderProm = iD_OrderProm;
		ID_Order = iD_Order;
		ID_Promotion = iD_Promotion;
		Quantity_OrderProm = quantity_OrderProm;
		Notes_OrderProm = notes_OrderProm;
	}

	public int getID_OrderProm() {
		return ID_OrderProm;
	}

	public void setID_OrderProm(int iD_OrderProm) {
		ID_OrderProm = iD_OrderProm;
	}

	public OrderT getID_Order() {
		return ID_Order;
	}

	public void setID_Order(OrderT iD_Order) {
		ID_Order = iD_Order;
	}

	public Promotion getID_Promotion() {
		return ID_Promotion;
	}

	public void setID_Promotion(Promotion iD_Promotion) {
		ID_Promotion = iD_Promotion;
	}

	public String getQuantity_OrderProm() {
		return Quantity_OrderProm;
	}

	public void setQuantity_OrderProm(String quantity_OrderProm) {
		Quantity_OrderProm = quantity_OrderProm;
	}

	public String getNotes_OrderProm() {
		return Notes_OrderProm;
	}

	public void setNotes_OrderProm(String notes_OrderProm) {
		Notes_OrderProm = notes_OrderProm;
	}
	
	
}
