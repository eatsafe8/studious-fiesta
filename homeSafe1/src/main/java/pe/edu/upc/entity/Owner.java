package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Owner")
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Owner;
	private int DNI_Owner;
	@Column(name = "FirstName_Owner", nullable = false, length = 50)
	private String FirstName_Owner;
	@Column(name = "LastName_Owner", nullable = false, length = 50)
	private String LastName_Owner;
	@Column(name = "Address_Owner", nullable = false, length = 50)
	private String Address_Owner;
	private int Cellphone_Owner;
	@Column(name = "Country_Owner", nullable = false, length = 50)
	private String Country_Owner;
	private long RUC_Owner;
	@Column(name = "Email_Owner", nullable = false, length = 50)
	private String Email_Owner;
	@Column(name = "Notes_Owner", nullable = true, length = 100)
	private String Notes_Owner;

	public Owner(int iD_Owner, int dNI_Owner, String firstName_Owner,
			String lastName_Owner, String address_Owner, int cellphone_Owner, String country_Owner, long rUC_Owner,
			String email_Owner, String notes_Owner) {
		super();
		ID_Owner = iD_Owner;
		DNI_Owner = dNI_Owner;
		FirstName_Owner = firstName_Owner;
		LastName_Owner = lastName_Owner;
		Address_Owner = address_Owner;
		Cellphone_Owner = cellphone_Owner;
		Country_Owner = country_Owner;
		RUC_Owner = rUC_Owner;
		Email_Owner = email_Owner;
		Notes_Owner = notes_Owner;
	}

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getID_Owner() {
		return ID_Owner;
	}

	public void setID_Owner(int iD_Owner) {
		ID_Owner = iD_Owner;
	}
	public int getDNI_Owner() {
		return DNI_Owner;
	}

	public void setDNI_Owner(int dNI_Owner) {
		DNI_Owner = dNI_Owner;
	}

	public String getFirstName_Owner() {
		return FirstName_Owner;
	}

	public void setFirstName_Owner(String firstName_Owner) {
		FirstName_Owner = firstName_Owner;
	}

	public String getLastName_Owner() {
		return LastName_Owner;
	}

	public void setLastName_Owner(String lastName_Owner) {
		LastName_Owner = lastName_Owner;
	}

	public String getAddress_Owner() {
		return Address_Owner;
	}

	public void setAddress_Owner(String address_Owner) {
		Address_Owner = address_Owner;
	}

	public int getCellphone_Owner() {
		return Cellphone_Owner;
	}

	public void setCellphone_Owner(int cellphone_Owner) {
		Cellphone_Owner = cellphone_Owner;
	}

	public String getCountry_Owner() {
		return Country_Owner;
	}

	public void setCountry_Owner(String country_Owner) {
		Country_Owner = country_Owner;
	}

	public long getRUC_Owner() {
		return RUC_Owner;
	}

	public void setRUC_Owner(long rUC_Owner) {
		RUC_Owner = rUC_Owner;
	}

	public String getEmail_Owner() {
		return Email_Owner;
	}

	public void setEmail_Owner(String email_Owner) {
		Email_Owner = email_Owner;
	}

	public String getNotes_Owner() {
		return Notes_Owner;
	}

	public void setNotes_Owner(String notes_Owner) {
		Notes_Owner = notes_Owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_Owner;
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
		Owner other = (Owner) obj;
		if (ID_Owner != other.ID_Owner)
			return false;
		return true;
	}
}
