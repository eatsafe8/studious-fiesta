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
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Reservation;
	
	@ManyToOne
	@JoinColumn(name = "ID_Restaurant", nullable = false)
	private Restaurant ID_Restaurant;
	
	@ManyToOne
	@JoinColumn(name = "ID_Customer", nullable = false)
	private Customer ID_Customer;
	
	@NotNull(message = "Ingrese FECHA DE RESERVACION")
	@Future(message = "La FECHA DE RESERVACION  debe ser futura")
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_Reservation")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date Date_Reservation;
	
	@NotEmpty(message="Ingrese HORA DE RESERVACION")
	@Column(name = "Time_Reservation", nullable = false, length = 10)
	private String Time_Reservation;
	
	@Pattern(regexp = "[0-9]*", message = "El campo Nro DE RESERVACIONES solo acepta numeros")
	@Size(min = 1, max = 2, message = "El campo Nro DE RESERVACIONES esta en el rango [1;99]")
	@NotEmpty(message = "Ingrese Nro DE RESERVACIONES")
	@Column(name = "NroPersons_Reservation", nullable =false , length=50)
	private String NroPersons_Reservation;
	
	@Column(name = "Notes_Reservation", length = 50)
	private String Notes_Reservation;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(int iD_Reservation, Restaurant iD_Restaurant, Customer iD_Customer,
			Date date_Reservation, String time_Reservation, String nroPersons_Reservation,
			String notes_Reservation) {
		super();
		ID_Reservation = iD_Reservation;
		ID_Restaurant = iD_Restaurant;
		ID_Customer = iD_Customer;
		Date_Reservation = date_Reservation;
		Time_Reservation = time_Reservation;
		NroPersons_Reservation = nroPersons_Reservation;
		Notes_Reservation = notes_Reservation;
	}

	public int getID_Reservation() {
		return ID_Reservation;
	}

	public void setID_Reservation(int iD_Reservation) {
		ID_Reservation = iD_Reservation;
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

	public String getNroPersons_Reservation() {
		return NroPersons_Reservation;
	}

	public void setNroPersons_Reservation(String nroPersons_Reservation) {
		NroPersons_Reservation = nroPersons_Reservation;
	}

	public String getNotes_Reservation() {
		return Notes_Reservation;
	}

	public void setNotes_Reservation(String notes_Reservation) {
		Notes_Reservation = notes_Reservation;
	}
	
	
}
