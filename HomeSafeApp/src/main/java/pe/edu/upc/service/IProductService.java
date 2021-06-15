package pe.edu.upc.service;

import java.util.List;


import pe.edu.upc.entities.Product;

public interface IProductService {
	public void insert(Product pr);

	List<Product> list();

	public void delete(int id);
}
