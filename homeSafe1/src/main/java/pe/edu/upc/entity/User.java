package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "id", nullable = false)
	private CustomerSecurity customerSecurity;

	@Column(name = "username", nullable = false, length = 30)
	private String username;

	@Column(name = "password", nullable = false, length = 80)
	private String password;

	@Column(name = "state", nullable = false, length = 1)
	private String state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CustomerSecurity getCustomerSecurity() {
		return customerSecurity;
	}

	public void setCustomerSecurity(CustomerSecurity customerSecurity) {
		this.customerSecurity = customerSecurity;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
