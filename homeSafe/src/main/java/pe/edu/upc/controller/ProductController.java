package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Product;
import pe.edu.upc.service.IProductService;

@Named
@RequestScoped
public class ProductController {

	@Inject
	private IProductService prService;
	
	private Product prod;
	
	List<Product> listaProductos;
	
	@PostConstruct
	public void init() {
		this.listaProductos = new ArrayList<Product>();
		this.prod = new Product();
		this.listarProductos();
	}

	public String nuevaProducto() {
		this.setProd(new Product());
		return "product.xhtml";
	}
	public void insertar() {
		try {
			prService.insert(prod);			
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller de producto");
		}
	}
	
	
	public void listarProductos() {
		try {
			listaProductos=prService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controller de producto");
		}
	}

	public void eliminar(Product prod) {
		try {
			prService.delete(prod.getiD_Product());
			this.listarProductos();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller de producto");
		}
	}
	
	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}

	public List<Product> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Product> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	
}
