package pe.edu.upc.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Restaurant")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Restaurant;
	
	@NotEmpty(message="Ingrese el nombre")
	@Column(name = "Name_Restaurant", nullable = false, length = 50)
	private String Name_Restaurant;
	
	@NotEmpty(message="Ingrese el aforo")
	@Digits(integer=1000, fraction=0)
	@Size(min=1, max=10)
	@Column(name = "Aforo_Restaurant", nullable = false, length = 10)
	private String Aforo_Restaurant;
	
	@NotEmpty(message="Ingrese dirección")
	@Column(name = "Address_Restaurant", nullable = false, length = 50)
	private String Address_Restaurant;
	
	@NotEmpty(message="Ingrese hora de abrir")
	@Column(name = "OpeningTime_Restaurant", nullable = false, length = 10)
	private String OpeningTime_Restaurant;

	@NotEmpty(message="Ingrese hora de cerrar")
	@Column(name = "ClosingTime_Restaurant", nullable = false, length = 10)
	private String ClosingTime_Restaurant;
	
	@NotEmpty(message="Ingrese la categoría")
	@Column(name = "Category_Restaurant", nullable = false, length = 50)
	private String Category_Restaurant;
	
	@Column(name = "Notes_Restaurant", nullable = true, length = 50)
	private String Notes_Restaurant;
	
	@NotNull(message="Ingrese dueño")
	@ManyToOne
	@JoinColumn(name = "ID_Owner", nullable = false)
	private Owner owner;

	

	public Restaurant(int iD_Restaurant, @NotEmpty(message = "Ingrese el nombre") String name_Restaurant,
			@NotEmpty(message = "Ingrese el aforo") @Digits(integer = 1000, fraction = 0) @Size(min = 1, max = 10) String aforo_Restaurant,
			@NotEmpty(message = "Ingrese dirección") String address_Restaurant,
			@NotEmpty(message = "Ingrese hora de abrir") String openingTime_Restaurant,
			@NotEmpty(message = "Ingrese hora de cerrar") String closingTime_Restaurant,
			@NotEmpty(message = "Ingrese la categoría") String category_Restaurant,
			String notes_Restaurant, @NotNull(message = "Ingrese dueño") Owner owner) {
		super();
		ID_Restaurant = iD_Restaurant;
		Name_Restaurant = name_Restaurant;
		Aforo_Restaurant = aforo_Restaurant;
		Address_Restaurant = address_Restaurant;
		OpeningTime_Restaurant = openingTime_Restaurant;
		ClosingTime_Restaurant = closingTime_Restaurant;
		Category_Restaurant = category_Restaurant;
		Notes_Restaurant = notes_Restaurant;
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_Restaurant;
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
		Restaurant other = (Restaurant) obj;
		if (ID_Restaurant != other.ID_Restaurant)
			return false;
		return true;
	}

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getID_Restaurant() {
		return ID_Restaurant;
	}

	public void setID_Restaurant(int iD_Restaurant) {
		ID_Restaurant = iD_Restaurant;
	}

	public String getName_Restaurant() {
		return Name_Restaurant;
	}

	public void setName_Restaurant(String name_Restaurant) {
		Name_Restaurant = name_Restaurant;
	}

	public String getAforo_Restaurant() {
		return Aforo_Restaurant;
	}

	public void setAforo_Restaurant(String aforo_Restaurant) {
		Aforo_Restaurant = aforo_Restaurant;
	}

	public String getAddress_Restaurant() {
		return Address_Restaurant;
	}

	public void setAddress_Restaurant(String address_Restaurant) {
		Address_Restaurant = address_Restaurant;
	}

	public String getOpeningTime_Restaurant() {
		return OpeningTime_Restaurant;
	}

	public void setOpeningTime_Restaurant(String openingTime_Restaurant) {
		OpeningTime_Restaurant = openingTime_Restaurant;
	}

	public String getClosingTime_Restaurant() {
		return ClosingTime_Restaurant;
	}

	public void setClosingTime_Restaurant(String closingTime_Restaurant) {
		ClosingTime_Restaurant = closingTime_Restaurant;
	}

	public String getCategory_Restaurant() {
		return Category_Restaurant;
	}

	public void setCategory_Restaurant(String category_Restaurant) {
		Category_Restaurant = category_Restaurant;
	}

	public String getNotes_Restaurant() {
		return Notes_Restaurant;
	}

	public void setNotes_Restaurant(String notes_Restaurant) {
		Notes_Restaurant = notes_Restaurant;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	
}
