package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Product;

public interface IProductDao {

	public void insert(Product prod);

	public List<Product> list();

	public void delete(int iD_Product);
}
