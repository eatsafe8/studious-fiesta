package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Product;
import pe.edu.upc.entity.Restaurant;
import pe.edu.upc.service.IProductService;
import pe.edu.upc.service.IRestaurantService;

@Named
@RequestScoped
public class ProductController {
	@Inject
	private IProductService prService;
	@Inject
	private IRestaurantService rtService;
	// Attributes
	private Product product;
	private Restaurant restaurant;
	List<Product> listaProducts;
	List<Restaurant> listaRestaurants;

	@PostConstruct
	public void init() {
		this.restaurant = new Restaurant();
		this.product = new Product();
		this.listaRestaurants = new ArrayList<Restaurant>();
		this.listaProducts = new ArrayList<Product>();
		this.listarProduct();
		this.listarRestaurant();
	}

	// Mutates
	public String nuevoProduct() {
		this.setProduct(new Product());
		return "Product.xhtml";
	}

	public void insertar() {
		try {
			prService.insert(product);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de producto");
			// TODO: handle exception
		}
	}

	public void listarRestaurant() {
		try {
			listaRestaurants = rtService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de restaurant");
			// TODO: handle exception
		}
	}

	public void listarProduct() {
		try {
			listaProducts = prService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de product");
			// TODO: handle exception
		}
	}

	public void eliminar(Product product) {
		try {
			prService.delete(product.getID_Product());
			this.listarProduct();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de product");
			// TODO: handle exception
		}
	}

	public void clean() {
		this.init();
	}

	public void findByName() {
		try {

			if (product.getName_Product().isEmpty()) {
				this.listarProduct();
			} else {
				listaProducts = this.prService.findByNameProduct(this.getProduct());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}

	public String modifPro(Product product) {
		this.setProduct(product);
		;
		return "ProductMod.xhtml";
	}

	public void modificar() {
		try {
			prService.update(this.product);
			this.listarProduct();
		} catch (Exception e) {
			System.out.println("Error al modificar en el controller de Product");
			// TODO: handle exception
		}
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<Product> getListaProducts() {
		return listaProducts;
	}

	public void setListaProducts(List<Product> listaProducts) {
		this.listaProducts = listaProducts;
	}

	public List<Restaurant> getListaRestaurants() {
		return listaRestaurants;
	}

	public void setListaRestaurants(List<Restaurant> listaRestaurants) {
		this.listaRestaurants = listaRestaurants;
	}

}
