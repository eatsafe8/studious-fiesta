package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Customer;
import pe.edu.upc.entities.Owner;
import pe.edu.upc.repository.OwnerRepository;
import pe.edu.upc.service.IOwnerService;

@Service
public class OwnerServiceImpl implements IOwnerService{
	@Autowired
	private OwnerRepository oR;
	
	@Override
	public void insert(Owner ow) {
		oR.save(ow);
	}
	
	@Override
	public List<Owner> list(){
		return oR.findAll();
	}
	
	@Override
	public void delete(int id) {
		oR.deleteById(id);
	}
	
	@Override
	public Optional<Owner> listarID(int ID_Owner) {
		// TODO Auto-generated method stub
		return oR.findById(ID_Owner);
	}
}
