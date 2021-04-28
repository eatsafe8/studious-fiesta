package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IProductDao;
import pe.edu.upc.entity.Product;
import pe.edu.upc.service.IProductService;

@Named
@RequestScoped
public class ProductServiceImpl implements IProductService{

	@Inject
	private IProductDao prDao;
	@Override
	public void insert(Product product) {
		prDao.insert(product);
	}

	@Override
	public List<Product> list() {
		return prDao.list();
	}

	@Override
	public void delete(int ID_Product) {
		prDao.delete(ID_Product);
	}
	//ss

}
