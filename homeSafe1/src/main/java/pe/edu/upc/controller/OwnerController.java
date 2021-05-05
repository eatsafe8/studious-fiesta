package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Owner;
import pe.edu.upc.service.IOwnerService;

@Named
@RequestScoped
public class OwnerController {
	@Inject
	private IOwnerService owService;
	
	// Attributes
	private Owner owner;
	List<Owner> listaOwner;
	
	//Mutates
	public String nuevoOwner() { 
		this.setOwner(new Owner());
		return "Owner.xhtml";
	}
	public void insertar() {
		try {
			owService.insert(owner);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de owner");
			// TODO: handle exception
		}
	}
	public void eliminar(Owner owner) {
		try {
			owService.delete(owner.getID_Owner());
			this.Listar();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de owner");
			// TODO: handle exception
		}
	}
	public void Listar() {
		try {
			listaOwner=owService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de owner");
			// TODO: handle exception
		}
	}

	// Constructors
		@PostConstruct
		public void init() {
			this.listaOwner = new ArrayList<Owner>();
			this.owner = new Owner();
			this.Listar();
		}

	
	
	
	//get y set
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public List<Owner> getListaOwner() {
		return listaOwner;
	}
	public void setListaOwner(List<Owner> listaOwner) {
		this.listaOwner = listaOwner;
	}
}
