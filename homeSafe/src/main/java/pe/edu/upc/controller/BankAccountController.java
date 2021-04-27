package pe.edu.upc.controller;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.BankAccount;
import pe.edu.upc.service.IBankAccountService;

@Named
@RequestScoped
public class BankAccountController {
	@Inject
	private IBankAccountService bkService;
	// Attributes

	private BankAccount bank;
	List<BankAccount> listaBankAccount;

	//Mutates
		public String nuevoBankAccount() { 
			this.setBank(new BankAccount());
			return "bankAccount.xhtml";
		}
		public void insertar() {
			try {
				bkService.insert(bank);
			} catch (Exception e) {
				System.out.println("Error al insertar en el controller de BankAccount");
				// TODO: handle exception
			}
		}
		public void eliminar(BankAccount bank) {
			try {
				bkService.delete(bank.getID_BankAccount());
				this.Listar();
			} catch (Exception e) {
				System.out.println("Error al eliminar en el controller de BankAccount");
				// TODO: handle exception
			}
		}
		public void Listar() {
			try {
				listaBankAccount=bkService.list();
			} catch (Exception e) {
				System.out.println("Error al listar en el controller de BankAccount");
				// TODO: handle exception
			}
		}
		
	
	
	// Constructors
	@PostConstruct
	public void init() {
		this.listaBankAccount = new ArrayList<BankAccount>();
		this.bank = new BankAccount();
		this.Listar();
	}



	public BankAccount getBank() {
		return bank;
	}

	public void setBank(BankAccount bank) {
		this.bank = bank;
	}

	public List<BankAccount> getListaBankAccount() {
		return listaBankAccount;
	}

	public void setListaBankAccount(List<BankAccount> listaBankAccount) {
		this.listaBankAccount = listaBankAccount;
	}
}
