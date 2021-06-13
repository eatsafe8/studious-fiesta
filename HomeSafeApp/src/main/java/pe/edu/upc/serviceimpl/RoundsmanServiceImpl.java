package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Roundsman;
import pe.edu.upc.repository.RoundsmanRepository;
import pe.edu.upc.service.IRoundsmanService;

@Service
public class RoundsmanServiceImpl implements IRoundsmanService{

	@Autowired
	private RoundsmanRepository rp;

	@Override
	public void insert(Roundsman rm) {
		rp.save(rm);
	}

	@Override
	public List<Roundsman> list() {
		// TODO Auto-generated method stub
		return rp.findAll();
	}

	@Override
	public void delete(int id) {
		rp.deleteById(id);
	}

	@Override
	public Optional<Roundsman> listarID(int ID_Roundsman) {
		// TODO Auto-generated method stub
		return rp.findById(ID_Roundsman);
	}

}
