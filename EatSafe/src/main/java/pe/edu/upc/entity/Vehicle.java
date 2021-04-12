package pe.edu.upc.entity;

public class Vehicle {
	private int ID_Vehicle;
	private int ID_Roundsman;
	private String LicenseNumber_Vehicle;
	private String Brand_Vehicle;
	private String Colour_Vehicle;
	private String Type_Vehicle;
	private String Notes_Vehicle;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(int iD_Vehicle, int iD_Roundsman, String licenseNumber_Vehicle, String brand_Vehicle,
			String colour_Vehicle, String type_Vehicle, String notes_Vehicle) {
		super();
		ID_Vehicle = iD_Vehicle;
		ID_Roundsman = iD_Roundsman;
		LicenseNumber_Vehicle = licenseNumber_Vehicle;
		Brand_Vehicle = brand_Vehicle;
		Colour_Vehicle = colour_Vehicle;
		Type_Vehicle = type_Vehicle;
		Notes_Vehicle = notes_Vehicle;
	}

	public int getID_Vehicle() {
		return ID_Vehicle;
	}

	public void setID_Vehicle(int iD_Vehicle) {
		ID_Vehicle = iD_Vehicle;
	}

	public int getID_Roundsman() {
		return ID_Roundsman;
	}

	public void setID_Roundsman(int iD_Roundsman) {
		ID_Roundsman = iD_Roundsman;
	}

	public String getLicenseNumber_Vehicle() {
		return LicenseNumber_Vehicle;
	}

	public void setLicenseNumber_Vehicle(String licenseNumber_Vehicle) {
		LicenseNumber_Vehicle = licenseNumber_Vehicle;
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

	public String getNotes_Vehicle() {
		return Notes_Vehicle;
	}

	public void setNotes_Vehicle(String notes_Vehicle) {
		Notes_Vehicle = notes_Vehicle;
	}

}
