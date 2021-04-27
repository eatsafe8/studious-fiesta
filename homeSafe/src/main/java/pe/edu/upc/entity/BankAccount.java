package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BankAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_BankAccount;
	@Column(name="Nro_BankAccount", nullable=false, length=50)
	private String Nro_BankAccount;
	@Column(name="Bank_BankAccount",nullable=false,length=50)
	private String Bank_BankAccount;
	@Column(name="Type_BankAccount",nullable=false,length=50)
	private String Type_BankAccount;
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(int ID_BankAccount, String Nro_BankAccount, String Bank_BankAccount, String Type_BankAccount) {
		super();
		this.ID_BankAccount = ID_BankAccount;
		this.Nro_BankAccount = Nro_BankAccount;
		this.Bank_BankAccount = Bank_BankAccount;
		this.Type_BankAccount = Type_BankAccount;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_BankAccount;
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
		BankAccount other = (BankAccount) obj;
		if (ID_BankAccount != other.ID_BankAccount)
			return false;
		return true;
	}
	
}
