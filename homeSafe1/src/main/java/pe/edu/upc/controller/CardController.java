package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Card;
import pe.edu.upc.entity.Owner;
import pe.edu.upc.service.ICardService;
import pe.edu.upc.service.IOwnerService;

@Named
@RequestScoped
public class CardController {
	@Inject
	private ICardService caService;
	@Inject
	private IOwnerService owService;

	// Attributes
	private Card card;
	List<Card> listaCards;
	private Owner owner;
	List<Owner> listaOwners;

	// Mutates
	public String nuevoCard() {
		this.setCard(new Card());
		return "Card.xhtml";
	}

	public void insertar() {
		try {
			caService.insert(card);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de Card");
			// TODO: handle exception
		}
	}
	public void listarOwner() {
		try {
			listaOwners = owService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de owner(Card)");
			// TODO: handle exception
		}
	}

	public void eliminar(Card card) {
		try {
			caService.delete(card.getID_Card());
			this.listarCard();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de Card");
			// TODO: handle exception
		}
	}

	public void listarCard() {
		try {
			listaCards = caService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de Card");
			// TODO: handle exception
		}
	}

	// Constructors
	@PostConstruct
	public void init() {
		this.owner = new Owner();
		this.card = new Card();
		this.listaCards = new ArrayList<Card>();
		this.listaOwners = new ArrayList<Owner>();
		this.listarOwner();
		this.listarCard();
	}

	// get y set
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public List<Card> getListaCards() {
		return listaCards;
	}

	public void setListaCards(List<Card> listaCards) {
		this.listaCards = listaCards;
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
