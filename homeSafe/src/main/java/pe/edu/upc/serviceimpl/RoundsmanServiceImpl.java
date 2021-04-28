package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IRoundsmanDao;
import pe.edu.upc.entity.Roundsman;
import pe.edu.upc.service.IRoundsmanService;


@Named
@RequestScoped
public class RoundsmanServiceImpl implements IRoundsmanService{
	@Inject
	private IRoundsmanDao rouDao;

	public void insert(Roundsman roundsman) {
		rouDao.insert(roundsman);
	}

	public List<Roundsman> list() {
	
		return rouDao.list();
	}

	public void delete(int ID_Roundsman) {
		rouDao.delete(ID_Roundsman);
	
	}
}