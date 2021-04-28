package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Product;

public interface IProductDao {

	public void insert(Product product);

	public List<Product> list();

	public void delete(int ID_Product);
	//xd
}
