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
@Table(name = "Restaurant")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Restaurant;
	@Column(name = "Name_Restaurant", nullable = false, length = 50)
	private String Name_Restaurant;
	private int Aforo_Restaurant;
	@Column(name = "Address_Restaurant", nullable = false, length = 50)
	private String Address_Restaurant;
	@Column(name = "OpeningTime_Restaurant", nullable = false, length = 20)
	private String OpeningTime_Restaurant;
	@Column(name = "ClosingTime_Restaurant", nullable = false, length = 20)
	private String ClosingTime_Restaurant;
	@Column(name = "Category_Restaurant", nullable = false, length = 50)
	private String Category_Restaurant;
	@Column(name = "Notes_Restaurant", nullable = false, length = 50)
	private String Notes_Restaurant;
	@ManyToOne
	@JoinColumn(name = "ID_Owner", nullable = false)
	private Owner owner;
	
	public Restaurant(int iD_Restaurant, String name_Restaurant, int aforo_Restaurant, String address_Restaurant,
			String openingTime_Restaurant, String closingTime_Restaurant, String category_Restaurant,
			String notes_Restaurant, Owner owner) {
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

	public int getAforo_Restaurant() {
		return Aforo_Restaurant;
	}

	public void setAforo_Restaurant(int aforo_Restaurant) {
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
