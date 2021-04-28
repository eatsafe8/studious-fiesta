package pe.edu.upc.service;

import java.util.List;
import pe.edu.upc.entity.Product;

public interface IProductService {

	public void insert(Product product);

	public List<Product> list();

	public void delete(int ID_Product);
	//...
}


