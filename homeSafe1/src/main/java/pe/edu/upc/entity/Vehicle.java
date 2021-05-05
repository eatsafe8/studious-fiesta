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
@Table(name = "Vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Vehicle;
	@Column(name = "Brand_Vehicle", nullable = false, length = 50)
	private String Brand_Vehicle;
	@Column(name = "Colour_Vehicle", nullable = false, length = 50)
	private String Colour_Vehicle;
	@Column(name = "Type_Vehicle", nullable = false, length = 50)
	private String Type_Vehicle;
	@Column(name = "LicenseNumber_Vehicle", nullable = false, length = 50)
	private String LicenseNumber_Vehicle;
	@Column(name = "Notes_Vehicle", nullable = false, length = 100)
	private String Notes_Vehicle;
	@ManyToOne
	@JoinColumn(name = "ID_Roundsman", nullable = false)
	private Roundsman roundsman;
	
	
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Vehicle(int iD_Vehicle, String brand_Vehicle, String colour_Vehicle, String type_Vehicle,
			String licenseNumber_Vehicle, String notes_Vehicle, Roundsman roundsman) {
		super();
		ID_Vehicle = iD_Vehicle;
		Brand_Vehicle = brand_Vehicle;
		Colour_Vehicle = colour_Vehicle;
		Type_Vehicle = type_Vehicle;
		LicenseNumber_Vehicle = licenseNumber_Vehicle;
		Notes_Vehicle = notes_Vehicle;
		this.roundsman = roundsman;
	}
	
	public int getID_Vehicle() {
		return ID_Vehicle;
	}
	public void setID_Vehicle(int iD_Vehicle) {
		ID_Vehicle = iD_Vehicle;
	}
	public String getBrand_Vehicle() {
		return Brand_Vehicle;
	}
	public void setBrand_Vehicle(String brand_Vehicle) {
		Brand_Vehicle = brand_Vehicle;
	}
	public String getColour_Vehicle() {
		return Colour_Vehicle;
	}
	public void setColour_Vehicle(String colour_Vehicle) {
		Colour_Vehicle = colour_Vehicle;
	}
	public String getType_Vehicle() {
		return Type_Vehicle;
	}
	public void setType_Vehicle(String type_Vehicle) {
		Type_Vehicle = type_Vehicle;
	}
	public String getLicenseNumber_Vehicle() {
		return LicenseNumber_Vehicle;
	}
	public void setLicenseNumber_Vehicle(String licenseNumber_Vehicle) {
		LicenseNumber_Vehicle = licenseNumber_Vehicle;
	}
	public String getNotes_Vehicle() {
		return Notes_Vehicle;
	}
	public void setNotes_Vehicle(String notes_Vehicle) {
		Notes_Vehicle = notes_Vehicle;
	}
	public Roundsman getRoundsman() {
		return roundsman;
	}
	public void setRoundsman(Roundsman roundsman) {
		this.roundsman = roundsman;
	}
}
