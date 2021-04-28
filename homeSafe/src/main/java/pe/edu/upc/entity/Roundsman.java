package pe.edu.upc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Roundsman")
public class Roundsman {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Roundsman;
	private int ID_DeliveryBusiness;
	private int DNI_Roundsman;
	
	@Column(name = "FirstName_Roundsman", nullable = false, length = 50)
	private String FirstName_Roundsman;
	
	@Column(name = "LastName_Roundsman", nullable = false, length = 50)
	private String LastName_Roundsman;
	
	@Column(name = "Address_Roundsman", nullable = false, length = 50)
	private String Address_Roundsman;
	
	@Column(name = "Cellphone_Roundsman", nullable = false, length = 50)
	private int Cellphone_Roundsman;
	
	@Column(name = "Sex_Roundsman", nullable = false, length = 50)
	private String Sex_Roundsman;
	
	@Column(name = "DateBirth_Roundsman", nullable = false, length = 50)
	private Date DateBirth_Roundsman;
	
	@Column(name = "Notes_Roundsman", nullable = false, length = 100)
	private String Notes_Roundsman;
	public Roundsman(){
		super();
	}
	
	public Roundsman(int iD_Roundsman, int iD_DeliveryBusiness, int dNI_Roundsman, String firstName_Roundsman,
			String lastName_Roundsman, String address_Roundsman, int cellphone_Roundsman, String sex_Roundsman, Date dateBirth_Roundsman, String notes_Roundsman) {
		super();
		ID_Roundsman = iD_Roundsman;
		ID_DeliveryBusiness = iD_DeliveryBusiness;
		DNI_Roundsman = dNI_Roundsman;
		FirstName_Roundsman = firstName_Roundsman;
		LastName_Roundsman = lastName_Roundsman;
		Address_Roundsman = address_Roundsman;
		Cellphone_Roundsman = cellphone_Roundsman;
		Sex_Roundsman = sex_Roundsman;
		DateBirth_Roundsman = dateBirth_Roundsman;
		Notes_Roundsman = notes_Roundsman;
	}
	
	public int getID_Roundsman() {
		return ID_Roundsman;
	}

	public void setID_Roundsman(int iD_Roundsman) {
		ID_Roundsman = iD_Roundsman;
	}
	

	public int getID_DeliveryBusiness() {
		return ID_DeliveryBusiness;
	}

	public void setID_DeliveryBusiness(int iD_DeliveryBusiness) {
		ID_DeliveryBusiness = iD_DeliveryBusiness;
	}
	

	public int getDNI_Roundsman() {
		return DNI_Roundsman;
	}

	public void setDNI_Roundsman(int dNI_Roundsman) {
		DNI_Roundsman = dNI_Roundsman;
	}
	

	public String getFirstName_Roundsman() {
		return FirstName_Roundsman;
	}

	public void setFirstName_Roundsman(String firstName_Roundsman) {
		FirstName_Roundsman = firstName_Roundsman;
	}
	

	public String getLastName_Roundsman() {
		return LastName_Roundsman;
	}

	public void setLastName_Roundsman(String lastName_Roundsman) {
		LastName_Roundsman = lastName_Roundsman;
	}
	

	public String getAddress_Roundsman() {
		return Address_Roundsman;
	}

	public void setAddress_Roundsman(String address_Roundsman) {
		Address_Roundsman = address_Roundsman;
	}
	

	public int getCellphone_Roundsman() {
		return Cellphone_Roundsman;
	}

	public void setCellphone_Roundsman(int cellphone_Roundsman) {
		Cellphone_Roundsman = cellphone_Roundsman;
	}
	
	
	public String getSex_Roundsman() {
		return Sex_Roundsman;
	}

	public void setSex_Roundsman(String sex_Roundsman) {
		Sex_Roundsman = sex_Roundsman;
	}
	
	
	public Date getDateBirth_Roundsman() {
		return DateBirth_Roundsman;
	}

	public void setDateBirth_Roundsman(Date dateBirth_Roundsman) {
		DateBirth_Roundsman = dateBirth_Roundsman;
	}
	
	
	public String getNotes_Roundsman() {
		return Notes_Roundsman;
	}

	public void setNotes_Roundsman(String notes_Roundsman) {
		Notes_Roundsman = notes_Roundsman;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_Roundsman;
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
		Roundsman other = (Roundsman) obj;
		if (ID_Roundsman != other.ID_Roundsman)
			return false;
		return true;
	}
	
}



