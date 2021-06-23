package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.edu.upc.entities.Product;
import pe.edu.upc.repository.ProductRepository;
import pe.edu.upc.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	private ProductRepository pR;
	
	@Override
	public void insert(Product pr) {
		pR.save(pr);
	}
	
	@Override
	public List<Product> list(){
		return pR.findAll();
	}
	
	@Override
	public void delete(int id) {
		pR.deleteById(id);
	}
	
	@Override
	public Optional<Product> listarId(int ID_Product){
		return pR.findById(ID_Product);
	}

	@Override
	public List<Product> searchNameIgnoreCase(String Name_Product) {
		// TODO Auto-generated method stub
		return pR.findByNameProductLikeIgnoreCase(Name_Product);
	}

	@Override
	public List<Product> findByName(String Name_Product) {
		// TODO Auto-generated method stub
		return pR.findByName(Name_Product);
	}

	@Override
	public List<String[]> prodXord() {
		// TODO Auto-generated method stub
		return pR.prodXord();
	}
}
