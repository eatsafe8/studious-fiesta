package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.BankAccount;

public interface IBankAccountService {
	public void insert(BankAccount ba);
	
	List<BankAccount> list();
	
	public void delete(int id);
	
	Optional<BankAccount> listarID(int id);
}
