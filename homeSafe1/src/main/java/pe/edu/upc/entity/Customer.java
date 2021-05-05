package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Customer;
	@Column(name = "DNI_Customer", nullable = false,length = 8)
	private String DNI_Customer;
	@Column(name = "FirstName_Customer", nullable = false, length = 50)
	private String FirstName_Customer;
	@Column(name = "LastName_Customer", nullable = false, length = 50)
	private String LastName_Customer;
	@Column(name = "Cellphone_Customer", nullable = false)
	private int Cellphone_Customer;
	@Column(name = "Email_Customer", nullable = false, length = 50)
	private String Email_Customer;
	@Column(name = "Adress_Customer", nullable = false, length = 50)
	private String Adress_Customer;
	@Column(name = "Notes_Customer", nullable = true, length = 50)
	private String Notes_Customer;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int iD_Customer, String dNI_Customer, String firstName_Customer, String lastName_Customer,
			int cellphone_Customer, String email_Customer, String adress_Customer, String notes_Customer) {
		super();
		ID_Customer = iD_Customer;
		DNI_Customer = dNI_Customer;
		FirstName_Customer = firstName_Customer;
		LastName_Customer = lastName_Customer;
		Cellphone_Customer = cellphone_Customer;
		Email_Customer = email_Customer;
		Adress_Customer = adress_Customer;
		Notes_Customer = notes_Customer;
	}

	public int getID_Customer() {
		return ID_Customer;
	}

	public void setID_Customer(int iD_Customer) {
		ID_Customer = iD_Customer;
	}
	public String getDNI_Customer() {
		return DNI_Customer;
	}

	public void setDNI_Customer(String dNI_Customer) {
		DNI_Customer = dNI_Customer;
	}
	

	public String getFirstName_Customer() {
		return FirstName_Customer;
	}

	public void setFirstName_Customer(String firstName_Customer) {
		FirstName_Customer = firstName_Customer;
	}

	public String getLastName_Customer() {
		return LastName_Customer;
	}

	public void setLastName_Customer(String lastName_Customer) {
		LastName_Customer = lastName_Customer;
	}

	public int getCellphone_Customer() {
		return Cellphone_Customer;
	}

	public void setCellphone_Customer(int cellphone_Customer) {
		Cellphone_Customer = cellphone_Customer;
	}

	public String getEmail_Customer() {
		return Email_Customer;
	}

	public void setEmail_Customer(String email_Customer) {
		Email_Customer = email_Customer;
	}

	public String getAdress_Customer() {
		return Adress_Customer;
	}

	public void setAdress_Customer(String adress_Customer) {
		Adress_Customer = adress_Customer;
	}

	public String getNotes_Customer() {
		return Notes_Customer;
	}

	public void setNotes_Customer(String notes_Customer) {
		Notes_Customer = notes_Customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_Customer;
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
		Customer other = (Customer) obj;
		if (ID_Customer != other.ID_Customer)
			return false;
		return true;
	}

}
