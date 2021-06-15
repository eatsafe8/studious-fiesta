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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Delivery")
public class Delivery {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Delivery;
	
	@ManyToOne
	@JoinColumn(name = "ID_Roundsman", nullable = false)
	private Roundsman ID_Roundsman;
	
	@ManyToOne
	@JoinColumn(name = "ID_Order", nullable = false)
	private OrderT ID_Order;
	
	@NotEmpty(message = "Ingrese DESTINO")
	@Column(name = "DestinationAdress",nullable = false, length=50)
	private String DestinationAdress;
	
	@NotNull(message = "Ingrese FECHA DE DELIVERY")
	@PastOrPresent(message = "La FECHA DE DELIVERY debe ser pasada")
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_Delivery")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date Date_Delivery;
	
	@NotEmpty(message = "Ingrese TIEMPO")
	@Column(name = "Time_Delivery", nullable = false, length = 50)
	private String Time_Delivery;
	
	@NotEmpty(message = "Ingrese DISTRITO")
	@Column(name = "District_Delivery", nullable = false, length = 50)
	private String District_Delivery;
	
	@DecimalMin(value="5.0",inclusive = false,message = "El precio mínimo es de 5 soles")
    @DecimalMax(value="1000.0",inclusive = false,message = "El precio máximo es de 1000 soles")
	@NotNull(message="Ingrese PRECIO")
	@Column(name = "Price_Delivery", nullable =false , length=50)
	private float Price_Delivery;
	
	@DecimalMin(value="0.0",inclusive = false,message = "El descuento mínimo es de 0%")
    @DecimalMax(value="70.0",inclusive = false,message = "El descuento máximo es de 70%")
	@NotNull(message="Ingrese DESCUENTO")
	@Column(name = "Discount_Delivery", nullable =false , length=50)
	private float Discount_Delivery;
	
	@Column(name = "Notes_Delivery", length=50)
	private String Notes_Delivery;
	
	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Delivery(int iD_Delivery, Roundsman iD_Roundsman, OrderT iD_Order, String destinationAdress, Date date_Delivery,
			String time_Delivery, String district_Delivery, float price_Delivery, float discount_Delivery, String notes_Delivery) {
		super();
		ID_Delivery = iD_Delivery;
		ID_Roundsman = iD_Roundsman;
		ID_Order = iD_Order;
		DestinationAdress = destinationAdress;
		Date_Delivery = date_Delivery;
		Time_Delivery = time_Delivery;
		District_Delivery = district_Delivery;
		Price_Delivery = price_Delivery;
		Discount_Delivery = discount_Delivery;
		Notes_Delivery = notes_Delivery;
	}

	public int getID_Delivery() {
		return ID_Delivery;
	}

	public void setID_Delivery(int iD_Delivery) {
		ID_Delivery = iD_Delivery;
	}

	public Roundsman getID_Roundsman() {
		return ID_Roundsman;
	}

	public void setID_Roundsman(Roundsman iD_Roundsman) {
		ID_Roundsman = iD_Roundsman;
	}

	public OrderT getID_Order() {
		return ID_Order;
	}

	public void setID_Order(OrderT iD_Order) {
		ID_Order = iD_Order;
	}

	public String getDestinationAdress() {
		return DestinationAdress;
	}

	public void setDestinationAdress(String destinationAdress) {
		DestinationAdress = destinationAdress;
	}

	public Date getDate_Delivery() {
		return Date_Delivery;
	}

	public void setDate_Delivery(Date date_Delivery) {
		Date_Delivery = date_Delivery;
	}

	public String getTime_Delivery() {
		return Time_Delivery;
	}

	public void setTime_Delivery(String time_Delivery) {
		Time_Delivery = time_Delivery;
	}

	public String getDistrict_Delivery() {
		return District_Delivery;
	}

	public void setDistrict_Delivery(String district_Delivery) {
		District_Delivery = district_Delivery;
	}

	public float getPrice_Delivery() {
		return Price_Delivery;
	}

	public void setPrice_Delivery(float price_Delivery) {
		Price_Delivery = price_Delivery;
	}

	public float getDiscount_Delivery() {
		return Discount_Delivery;
	}

	public void setDiscount_Delivery(float discount_Delivery) {
		Discount_Delivery = discount_Delivery;
	}

	public String getNotes_Delivery() {
		return Notes_Delivery;
	}

	public void setNotes_Delivery(String notes_Delivery) {
		Notes_Delivery = notes_Delivery;
	}
	
	
}
