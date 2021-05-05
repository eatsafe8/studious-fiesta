package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Promotion;
import pe.edu.upc.entity.Restaurant;
import pe.edu.upc.service.IPromotionService;
import pe.edu.upc.service.IRestaurantService;

@Named
@RequestScoped
public class PromotionController {
	@Inject
	private IPromotionService prService;
	@Inject
	private IRestaurantService rtService;

	private Promotion promotion;
	private Restaurant restaurant;
	List<Promotion> listaPromotions;
	List<Restaurant> listaRestaurants;

	@PostConstruct
	private void init() {
		this.promotion = new Promotion();
		this.restaurant = new Restaurant();
		this.listaPromotions = new ArrayList<Promotion>();
		this.listaRestaurants = new ArrayList<Restaurant>();
		this.listarPromotion();
		this.listarRestaurant();
	}

	public String nuevoPromotion() {
		this.setPromotion(new Promotion());
		return "Promotion.xhtml";
	}

	public void insertar() {
		try {
			prService.insert(promotion);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de promotion");
		}
	}

	public void listarRestaurant() {
		try {
			listaRestaurants = rtService.list();
		} catch (Exception e) {
			System.out.println("Error al listar restaurants en el controller de promotion");
		}
	}

	public void listarPromotion() {
		try {
			listaPromotions = prService.list();
		} catch (Exception e) {
			System.out.println("Error al listar promotions en el controller de promotion");
		}
	}

	public void eliminar(Promotion promotion) {
		try {
			prService.delete(promotion.getID_Promotion());
			this.listarPromotion();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de promotion");
		}
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<Promotion> getListaPromotions() {
		return listaPromotions;
	}

	public void setListaPromotions(List<Promotion> listaPromotions) {
		this.listaPromotions = listaPromotions;
	}

	public List<Restaurant> getListaRestaurants() {
		return listaRestaurants;
	}

	public void setListaRestaurants(List<Restaurant> listaRestaurants) {
		this.listaRestaurants = listaRestaurants;
	}

}
