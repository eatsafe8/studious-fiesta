package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.BankAccount;

public interface IBankAccountDao {
	public void insert(BankAccount bankaccount);
	public List<BankAccount>list();
	public void delete(int ID_BankAccount);
}
