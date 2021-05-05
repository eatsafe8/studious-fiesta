package pe.edu.upc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Delivery")
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Delivery;
	
	@ManyToOne
	@JoinColumn(name = "ID_Customer", nullable = false)
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "ID_Roundsman", nullable = false)
	private Roundsman roundsman;
	
	@ManyToOne
	@JoinColumn(name = "ID_Order", nullable = false)
	private Order order;
	
	@Column(name = "DestinationAdress", nullable = false, length = 50)
	private String DestinationAdress;
	
	private Date Date_Delivery;
	
	@Column(name = "Time_Delivery", length = 10, nullable = false)
	private String Time_Delivery;
	
	@Column(name = "District_Delivery", nullable = false, length = 50)
	private String District_Delivery;
	
	private float Price_Delivery;
	
	private float Discount_Delivery;
	
	@Column(name = "Notes_Delivery", nullable = false, length = 50)
	private String Notes_Delivery;

	
	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Delivery(int iD_Delivery, Customer customer, Roundsman roundsman, Order order, String destinationAdress,
			Date date_Delivery, String time_Delivery, String district_Delivery, float price_Delivery,
			float discount_Delivery, String notes_Delivery) {
		super();
		ID_Delivery = iD_Delivery;
		this.customer = customer;
		this.roundsman = roundsman;
		this.order = order;
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
