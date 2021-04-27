package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Card;
import pe.edu.upc.service.ICardService;

@Named
@RequestScoped
public class CardController {
	@Inject
	private ICardService caService;
	// Attributes

	private Card card;
	List<Card> listaCard;
	
	//Mutates
			public String nuevoCard() { 
				this.setCard(new Card());
				return "card.xhtml";
			}
			public void insertar() {
				try {
					caService.insert(card);
				} catch (Exception e) {
					System.out.println("Error al insertar en el controller de Card");
					// TODO: handle exception
				}
			}
			public void eliminar(Card card) {
				try {
					caService.delete(card.getID_Card());
					this.Listar();
				} catch (Exception e) {
					System.out.println("Error al eliminar en el controller de Card");
					// TODO: handle exception
				}
			}
			public void Listar() {
				try {
					listaCard=caService.list();
				} catch (Exception e) {
					System.out.println("Error al listar en el controller de Card");
					// TODO: handle exception
				}
			}
	
	
	
	// Constructors
		@PostConstruct
		public void init() {
			this.listaCard = new ArrayList<Card>();
			this.card = new Card();
			this.Listar();
		}
	
	//get y set
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public List<Card> getListaCard() {
		return listaCard;
	}
	public void setListaCard(List<Card> listaCard) {
		this.listaCard = listaCard;
	}
}
