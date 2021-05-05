package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.DetailPromotion;
import pe.edu.upc.entity.Product;
import pe.edu.upc.entity.Promotion;
import pe.edu.upc.service.IDetailPromotionService;
import pe.edu.upc.service.IProductService;
import pe.edu.upc.service.IPromotionService;

@Named
@RequestScoped
public class DetailPromotionController {
	@Inject
	private IDetailPromotionService dpService;

	@Inject
	private IPromotionService pmService;

	@Inject
	private IProductService prService;

	private DetailPromotion detailPromotion;
	private Promotion promotion;
	private Product product;
	List<DetailPromotion> listaDetailPromotions;
	List<Promotion> listaPromotions;
	List<Product> listaProducts;

	@PostConstruct
	private void init() {
		this.detailPromotion = new DetailPromotion();
		this.promotion = new Promotion();
		this.product = new Product();
		this.listaDetailPromotions = new ArrayList<DetailPromotion>();
		this.listaPromotions = new ArrayList<Promotion>();
		this.listaProducts = new ArrayList<Product>();
		this.listarDetailPromotion();
		this.listarPromotion();
		this.listarProduct();
	}

	public String nuevoDetailPromotion() {
		this.setDetailPromotion(new DetailPromotion());
		return "DetailPromotion.xhtml";
	}

	public void insertar() {
		try {
			dpService.insert(detailPromotion);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de DetailPromotion");
		}
	}

	public void listarPromotion() {
		try {
			listaPromotions = pmService.list();
		} catch (Exception e) {
			System.out.println("Error al listar las promociones en el controller de DetailPromotion");
		}
	}

	public void listarProduct() {
		try {
			listaProducts = prService.list();
		} catch (Exception e) {
			System.out.println("Error al listar los productos en el controller de DetailPromotion");
		}

	}

	public void listarDetailPromotion() {
		try {
			listaDetailPromotions = dpService.list();
		} catch (Exception e) {
			System.out.println("Error al listar los detailPromotions en el controller de DetailPromotion");
		}
	}

	public void eliminar(DetailPromotion detailPromotion) {
		try {
			dpService.delete(detailPromotion.getID_DetailPromotion());
			this.listarDetailPromotion();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de DetailPromotion");
		}
	}

	public DetailPromotion getDetailPromotion() {
		return detailPromotion;
	}

	public void setDetailPromotion(DetailPromotion detailPromotion) {
		this.detailPromotion = detailPromotion;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<DetailPromotion> getListaDetailPromotions() {
		return listaDetailPromotions;
	}

	public void setListaDetailPromotions(List<DetailPromotion> listaDetailPromotions) {
		this.listaDetailPromotions = listaDetailPromotions;
	}

	public List<Promotion> getListaPromotions() {
		return listaPromotions;
	}

	public void setListaPromotions(List<Promotion> listaPromotions) {
		this.listaPromotions = listaPromotions;
	}

	public List<Product> getListaProducts() {
		return listaProducts;
	}

	public void setListaProducts(List<Product> listaProducts) {
		this.listaProducts = listaProducts;
	}

}
