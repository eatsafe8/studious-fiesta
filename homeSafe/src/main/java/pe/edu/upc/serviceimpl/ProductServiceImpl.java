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
	private IProductDao pDao;
	@Override
	public void insert(Product prod) {
		pDao.insert(prod);
	}

	@Override
	public List<Product> list() {
		return pDao.list();
	}

	@Override
	public void delete(int iD_Product) {
		pDao.delete(iD_Product);
	}

}
