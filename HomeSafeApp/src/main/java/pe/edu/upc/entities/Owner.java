package pe.edu.upc.entities;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Owner")
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Owner;
	
	@NotEmpty(message="Ingrese DNI")
	@Digits(integer=8, fraction=0)
	@Size(min=8, max=8)
	@Column(name = "DNI_Owner", nullable = false,length = 8)
	private String DNI_Owner;
	
	@NotEmpty(message="Ingrese nombres")
	@Column(name = "FirstName_Owner", nullable = false, length = 50)
	private String FirstName_Owner;
	
	@NotEmpty(message="Ingrese apellidos")
	@Column(name = "LastName_Owner", nullable = false, length = 50)
	private String LastName_Owner;
	
	@NotEmpty(message="Ingrese dirección")
	@Column(name = "Address_Owner", nullable = false, length = 50)
	private String Address_Owner;
	
	@NotEmpty(message="Ingrese celular")
	@Digits(integer=9, fraction=0)
	@Size(min=9, max=9)
	@Column(name = "Cellphone_Owner", nullable = false, length=9)
	private String Cellphone_Owner;
	
	@NotEmpty(message="Ingrese país")
	@Column(name = "Country_Owner", nullable = false, length = 50)
	private String Country_Owner;

	@NotEmpty(message="Ingrese RUC")
	@Digits(integer=11, fraction=0)
	@Size(min=11, max=11)
	@Column(name="RUC_Owner",nullable=false, length=11)
	private String RUC_Owner;
	
	@NotEmpty(message="Ingrese email")
	@Email
	@Column(name = "Email_Owner", nullable = false, length = 50)
	private String Email_Owner;
	
	@Column(name = "Notes_Owner", nullable = true, length = 100)
	private String Notes_Owner;

	public Owner(int iD_Owner,
			@NotEmpty(message = "Ingrese DNI") @Digits(integer = 8, fraction = 0) @Size(min = 8, max = 8) String dNI_Owner,
			@NotEmpty(message = "Ingrese nombres") String firstName_Owner,
			@NotEmpty(message = "Ingrese apellidos")  String lastName_Owner,
			@NotEmpty(message = "Ingrese dirección") String address_Owner,
			@NotEmpty(message = "Ingrese celular") @Digits(integer = 9, fraction = 0) @Size(min = 9, max = 9) String cellphone_Owner,
			@NotEmpty(message = "Ingrese país")  String country_Owner,
			@NotEmpty(message = "Ingrese RUC") @Digits(integer = 11, fraction = 0) @Size(min = 11, max = 11) String rUC_Owner,
			@NotEmpty(message = "Ingrese email") @Email String email_Owner, String notes_Owner) {
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

	public String getDNI_Owner() {
		return DNI_Owner;
	}

	public void setDNI_Owner(String dNI_Owner) {
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

	public String getCellphone_Owner() {
		return Cellphone_Owner;
	}

	public void setCellphone_Owner(String cellphone_Owner) {
		Cellphone_Owner = cellphone_Owner;
	}

	public String getCountry_Owner() {
		return Country_Owner;
	}

	public void setCountry_Owner(String country_Owner) {
		Country_Owner = country_Owner;
	}

	public String getRUC_Owner() {
		return RUC_Owner;
	}

	public void setRUC_Owner(String rUC_Owner) {
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
