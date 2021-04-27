package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IOwnerDao;
import pe.edu.upc.entity.Owner;
import pe.edu.upc.service.IOwnerService;


@Named
@RequestScoped
public class OwnerServiceImpl implements IOwnerService{
	@Inject	
	private IOwnerDao owDao;

public void insert(Owner owner) {
	// TODO Auto-generated method stub
	owDao.insert(owner);
}

public List<Owner> list() {
	
	return owDao.list();
}

public void delete(int ID_Owner) {
	owDao.delete(ID_Owner);
	
}
}
