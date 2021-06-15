package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "OrderT")
public class OrderT {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Order;
	
	@ManyToOne
	@JoinColumn(name = "ID_Restaurant", nullable = false)
	private Restaurant ID_Restaurant;
	
	@ManyToOne
	@JoinColumn(name = "ID_Customer", nullable = false)
	private Customer ID_Customer;
	
	@DecimalMin(value="5.0",inclusive = false,message = "El precio mínimo es de 5 soles")
    @DecimalMax(value="1000.0",inclusive = false,message = "El precio máximo es de 1000 soles")
	@NotNull(message="Ingrese PRECIO")
	@Column(name = "Price_Order", nullable =false , length=50)
	private float Price_Order;
	
	@DecimalMin(value="0.0",inclusive = false,message = "El descuento mínimo es de 0%")
    @DecimalMax(value="70.0",inclusive = false,message = "El descuento máximo es de 70%")
	@NotNull(message="Ingrese DESCUENTO")
	@Column(name = "Discount_Price", nullable =false , length=50)
	private float Discount_Price;
	
	@NotNull(message = "Ingrese FECHA DE PEDIDO")
	@PastOrPresent(message = "La FECHA DEL PEDIDO debe ser pasada")
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_Order")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date Date_Order;
	
	@Column(name = "Notes_Order", length=50)
	private String Notes_Order;
	
	public OrderT() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderT(int iD_Order, Restaurant iD_Restaurant, Customer iD_Customer, float price_Order, float discount_Price,
			Date date_Order, String notes_Order) {
		super();
		ID_Order = iD_Order;
		ID_Restaurant = iD_Restaurant;
		ID_Customer = iD_Customer;
		Price_Order = price_Order;
		Discount_Price = discount_Price;
		Date_Order = date_Order;
		Notes_Order = notes_Order;
	}

	public int getID_Order() {
		return ID_Order;
	}

	public void setID_Order(int iD_Order) {
		ID_Order = iD_Order;
	}

	public Restaurant getID_Restaurant() {
		return ID_Restaurant;
	}

	public void setID_Restaurant(Restaurant iD_Restaurant) {
		ID_Restaurant = iD_Restaurant;
	}

	public Customer getID_Customer() {
		return ID_Customer;
	}

	public void setID_Customer(Customer iD_Customer) {
		ID_Customer = iD_Customer;
	}

	public float getPrice_Order() {
		return Price_Order;
	}

	public void setPrice_Order(float price_Order) {
		Price_Order = price_Order;
	}

	public float getDiscount_Price() {
		return Discount_Price;
	}

	public void setDiscount_Price(float discount_Price) {
		Discount_Price = discount_Price;
	}

	public Date getDate_Order() {
		return Date_Order;
	}

	public void setDate_Order(Date date_Order) {
		Date_Order = date_Order;
	}

	public String getNotes_Order() {
		return Notes_Order;
	}

	public void setNotes_Order(String notes_Order) {
		Notes_Order = notes_Order;
	}
}
