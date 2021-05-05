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
@Table(name = "Reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Reservation;

	private Date Date_Reservation;

	@Column(name = "Time_Reservation", length = 10, nullable = false)
	private String Time_Reservation;

	private int NroPersons_Reservation;

	@Column(name = "Notes_Reservation", length = 50, nullable = false)
	private String Notes_Reservation;

	@ManyToOne
	@JoinColumn(name = "ID_Restaurant", nullable = false)
	private Restaurant restaurant;

	@ManyToOne
	@JoinColumn(name = "ID_Customer", nullable = false)
	private Customer customer;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(int iD_Reservation, Date date_Reservation, String time_Reservation, int nroPersons_Reservation,
			String notes_Reservation, Restaurant restaurant, Customer customer) {
		super();
		ID_Reservation = iD_Reservation;
		Date_Reservation = date_Reservation;
		Time_Reservation = time_Reservation;
		NroPersons_Reservation = nroPersons_Reservation;
		Notes_Reservation = notes_Reservation;
		this.restaurant = restaurant;
		this.customer = customer;
	}

	public int getID_Reservation() {
		return ID_Reservation;
	}

	public void setID_Reservation(int iD_Reservation) {
		ID_Reservation = iD_Reservation;
	}

	public Date getDate_Reservation() {
		return Date_Reservation;
	}

	public void setDate_Reservation(Date date_Reservation) {
		Date_Reservation = date_Reservation;
	}

	public String getTime_Reservation() {
		return Time_Reservation;
	}

	public void setTime_Reservation(String time_Reservation) {
		Time_Reservation = time_Reservation;
	}

	public int getNroPersons_Reservation() {
		return NroPersons_Reservation;
	}

	public void setNroPersons_Reservation(int nroPersons_Reservation) {
		NroPersons_Reservation = nroPersons_Reservation;
	}

	public String getNotes_Reservation() {
		return Notes_Reservation;
	}

	public void setNotes_Reservation(String notes_Reservation) {
		Notes_Reservation = notes_Reservation;
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

}
