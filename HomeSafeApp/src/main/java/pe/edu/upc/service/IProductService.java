package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Product;

public interface IProductService {
	public void insert(Product pr);

	List<Product> list();

	public void delete(int id);
	
	Optional<Product> listarId(int ID_Product);
	
	List<Product> searchNameIgnoreCase(String Name_Product);
	
	List<Product> findByName(String Name_Product);
	
	public List<String[]> prodXord();
	
	public List<String[]> ProdVendPrim6Mes();
}
