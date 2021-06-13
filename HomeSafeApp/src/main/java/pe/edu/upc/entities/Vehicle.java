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

@Entity
@Table(name = "Vehicle")
public class Vehicle {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Vehicle;
	
	@ManyToOne
	@JoinColumn(name = "ID_Roundsman", nullable =false)
	private Roundsman ID_Roundsman;
	
	@NotEmpty(message = "Ingrese MARCA")
	@Column(name = "Brand_Vehicle", nullable =false , length=50)
	private String Brand_Vehicle;
	
	@NotEmpty(message = "Ingrese COLOR")
	@Column(name = "Colour_Vehicle", nullable =false , length=50)
	private String Colour_Vehicle;
	
	@NotEmpty(message = "Ingrese TIPO")
	@Column(name = "Type_Vehicle", nullable =false , length=50)
	private String Type_Vehicle;
	
	@NotEmpty(message = "Ingrese LICENCIA")
	@Column(name = "LicenseNumber_Vehicle", nullable =false , length=50)
	private String LicenseNumber_Vehicle;
	
	@NotEmpty(message = "Ingrese notas")
	@Column(name = "Notes_Vehicle", nullable =false , length=50)
	private String Notes_Vehicle;

	
	
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(int iD_Vehicle, Roundsman iD_Roundsman, String brand_Vehicle,
			 String colour_Vehicle, String type_Vehicle, String licenseNumber_Vehicle, String notes_Vehicle) {
		super();
		ID_Vehicle = iD_Vehicle;
		ID_Roundsman = iD_Roundsman;
		Brand_Vehicle = brand_Vehicle;
		Colour_Vehicle = colour_Vehicle;
		Type_Vehicle = type_Vehicle;
		LicenseNumber_Vehicle = licenseNumber_Vehicle;
		Notes_Vehicle = notes_Vehicle;
	}

	public int getID_Vehicle() {
		return ID_Vehicle;
	}

	public void setID_Vehicle(int iD_Vehicle) {
		ID_Vehicle = iD_Vehicle;
	}

	public Roundsman getID_Roundsman() {
		return ID_Roundsman;
	}

	public void setID_Roundsman(Roundsman iD_Roundsman) {
		ID_Roundsman = iD_Roundsman;
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
	
}
