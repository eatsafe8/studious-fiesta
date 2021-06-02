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
import javax.validation.constraints.Size;

@Entity
@Table(name = "BankAccount")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_BankAccount;

	@NotEmpty(message = "Ingrese el número de cuenta bancaria")
	@Digits(integer = 20, fraction = 0)
	@Size(min = 20, max = 20)
	@Column(name = "Nro_BankAccount", nullable = false, length = 20)
	private String Nro_BankAccount;

	@NotEmpty(message = "Ingrese el nombre del banco")
	@Column(name = "Bank_BankAccount", nullable = false, length = 50)
	private String Bank_BankAccount;
	
	@NotEmpty(message = "Ingrese el tipo de cuenta")
	@Column(name = "Type_BankAccount", nullable = false, length = 50)
	private String Type_BankAccount;
	
	@ManyToOne
	@JoinColumn(name = "ID_Owner", nullable = false)
	private Owner ID_Owner;

	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccount(int iD_BankAccount,
			@NotEmpty(message = "Ingrese el número de cuenta bancaria") @Digits(integer = 20, fraction = 0) @Size(min = 20, max = 20) String nro_BankAccount,
			@NotEmpty(message = "Ingrese el nombre del banco") String bank_BankAccount,
			@NotEmpty(message = "Ingrese el tipo de cuenta") String type_BankAccount, Owner iD_Owner) {
		super();
		ID_BankAccount = iD_BankAccount;
		Nro_BankAccount = nro_BankAccount;
		Bank_BankAccount = bank_BankAccount;
		Type_BankAccount = type_BankAccount;
		ID_Owner = iD_Owner;
	}

	public int getID_BankAccount() {
		return ID_BankAccount;
	}

	public void setID_BankAccount(int iD_BankAccount) {
		ID_BankAccount = iD_BankAccount;
	}

	public String getNro_BankAccount() {
		return Nro_BankAccount;
	}

	public void setNro_BankAccount(String nro_BankAccount) {
		Nro_BankAccount = nro_BankAccount;
	}

	public String getBank_BankAccount() {
		return Bank_BankAccount;
	}

	public void setBank_BankAccount(String bank_BankAccount) {
		Bank_BankAccount = bank_BankAccount;
	}

	public String getType_BankAccount() {
		return Type_BankAccount;
	}

	public void setType_BankAccount(String type_BankAccount) {
		Type_BankAccount = type_BankAccount;
	}

	public Owner getID_Owner() {
		return ID_Owner;
	}

	public void setID_Owner(Owner iD_Owner) {
		ID_Owner = iD_Owner;
	}

}
