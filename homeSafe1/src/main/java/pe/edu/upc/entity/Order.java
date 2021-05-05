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
@Table(name = "tOrder")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Order;

	private float Price_Order;

	private float Discount_Order;

	private Date Date_Order;

	@Column(name = "Notes_Order", length = 100, nullable = false)
	private String Notes_Order;

	@ManyToOne
	@JoinColumn(name = "ID_Restaurant", nullable = false)
	private Restaurant restaurant;

	@ManyToOne
	@JoinColumn(name = "ID_Customer", nullable = false)
	private Customer customer;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int iD_Order, float price_Order, float discount_Order, Date date_Order, String notes_Order,
			Restaurant restaurant, Customer customer) {
		super();
		ID_Order = iD_Order;
		Price_Order = price_Order;
		Discount_Order = discount_Order;
		Date_Order = date_Order;
		Notes_Order = notes_Order;
		this.restaurant = restaurant;
		this.customer = customer;
	}

	public int getID_Order() {
		return ID_Order;
	}

	public void setID_Order(int iD_Order) {
		ID_Order = iD_Order;
	}

	public float getPrice_Order() {
		return Price_Order;
	}

	public void setPrice_Order(float price_Order) {
		Price_Order = price_Order;
	}

	public float getDiscount_Order() {
		return Discount_Order;
	}

	public void setDiscount_Order(float discount_Order) {
		Discount_Order = discount_Order;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_Order;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (ID_Order != other.ID_Order)
			return false;
		return true;
	}

}
