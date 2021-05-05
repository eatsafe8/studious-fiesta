package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.BankAccount;
import pe.edu.upc.entity.Owner;
import pe.edu.upc.service.IBankAccountService;
import pe.edu.upc.service.IOwnerService;

@Named
@RequestScoped
public class BankAccountController {
	@Inject
	private IBankAccountService bkService;
	@Inject
	private IOwnerService owService;

	// Attributes
	private BankAccount bankaccount;
	List<BankAccount> listaBankAccounts;
	private Owner owner;
	List<Owner> listaOwners;

	// Constructors
	@PostConstruct
	public void init() {
		this.owner = new Owner();
		this.bankaccount = new BankAccount();
		this.listaBankAccounts = new ArrayList<BankAccount>();
		this.listaOwners = new ArrayList<Owner>();
		this.listarOwner();
		this.listarBankAccount();
	}

	// Mutates
	public String nuevoBankAccount() {
		this.setBankaccount(new BankAccount());
		return "BankAccount.xhtml";
	}

	public void insertar() {
		try {
			bkService.insert(bankaccount);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de BankAccount");
			// TODO: handle exception
		}
	}
	public void listarOwner() {
		try {
			listaOwners = owService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de owner");
			// TODO: handle exception
		}
	}

	public void eliminar(BankAccount bank) {
		try {
			bkService.delete(bank.getID_BankAccount());
			this.listarBankAccount();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de BankAccount");
			// TODO: handle exception
		}
	}

	public void listarBankAccount() {
		try {
			listaBankAccounts = bkService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de BankAccount");
			// TODO: handle exception
		}
	}

	//get y set
	public BankAccount getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(BankAccount bankaccount) {
		this.bankaccount = bankaccount;
	}

	public List<BankAccount> getListaBankAccounts() {
		return listaBankAccounts;
	}

	public void setListaBankAccounts(List<BankAccount> listaBankAccounts) {
		this.listaBankAccounts = listaBankAccounts;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List<Owner> getListaOwners() {
		return listaOwners;
	}

	public void setListaOwners(List<Owner> listaOwners) {
		this.listaOwners = listaOwners;
	}

}
