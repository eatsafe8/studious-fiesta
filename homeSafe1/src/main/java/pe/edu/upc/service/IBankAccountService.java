package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.BankAccount;

public interface IBankAccountService {
	public void insert(BankAccount bankaccount);
	public List<BankAccount>list();
	public void delete(int ID_BankAccount);

}
