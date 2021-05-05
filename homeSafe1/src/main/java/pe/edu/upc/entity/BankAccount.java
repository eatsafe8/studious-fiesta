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
@Table(name = "BankAccount")
public class BankAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_BankAccount;
	private long Nro_BankAccount;
	@Column(name="Bank_BankAccount",nullable=false,length=50)
	private String Bank_BankAccount;
	@Column(name="Type_BankAccount",nullable=false,length=50)
	private String Type_BankAccount;
	@ManyToOne
	@JoinColumn(name = "ID_Owner", nullable = true)
	private Owner owner;
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(int iD_BankAccount, long nro_BankAccount, String bank_BankAccount, String type_BankAccount,
			Owner owner) {
		super();
		ID_BankAccount = iD_BankAccount;
		Nro_BankAccount = nro_BankAccount;
		Bank_BankAccount = bank_BankAccount;
		Type_BankAccount = type_BankAccount;
		this.owner = owner;
	}
	
	//get and set
	public int getID_BankAccount() {
		return ID_BankAccount;
	}
	public void setID_BankAccount(int iD_BankAccount) {
		ID_BankAccount = iD_BankAccount;
	}
	public long getNro_BankAccount() {
		return Nro_BankAccount;
	}
	public void setNro_BankAccount(long nro_BankAccount) {
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
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}
