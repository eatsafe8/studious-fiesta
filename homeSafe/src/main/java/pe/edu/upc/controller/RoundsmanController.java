package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Roundsman;
import pe.edu.upc.service.IRoundsmanService;

@Named
@RequestScoped
public class RoundsmanController {
	@Inject
	private IRoundsmanService rouService;
	
	// Attributes
	private Roundsman roundsman;
	List<Roundsman> listaRoundsman;
	
	//Mutates
	public String nuevoRoundsman() { 
		this.setRoundsman(new Roundsman());
		return "Roundsman.xhtml";
	}
	public void insertar() {
		try {
			rouService.insert(roundsman);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de repartidor");
			// TODO: handle exception
		}
	}
	public void eliminar(Roundsman roundsman) {
		try {
			rouService.delete(roundsman.getID_Roundsman());
			this.Listar();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de repartidor");
			// TODO: handle exception
		}
	}
	public void Listar() {
		try {
			listaRoundsman=rouService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de repartidor");
			// TODO: handle exception
		}
	}

	// Constructors
		@PostConstruct
		public void init() {
			this.listaRoundsman = new ArrayList<Roundsman>();
			this.roundsman = new Roundsman();
			this.Listar();
		}

	
	
	
	//get y set
	public Roundsman getRoundsman() {
		return roundsman;
	}
	public void setRoundsman(Roundsman roundsman) {
		this.roundsman = roundsman;
	}
	public List<Roundsman> getListaRoundsman() {
		return listaRoundsman;
	}
	public void setListaRoundsman(List<Roundsman> listaRoundsman) {
		this.listaRoundsman = listaRoundsman;
	}
}
