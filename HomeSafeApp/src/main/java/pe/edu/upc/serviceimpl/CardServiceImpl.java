package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Card;
import pe.edu.upc.repository.CardRepository;
import pe.edu.upc.service.ICardService;

@Service
public class CardServiceImpl implements ICardService{
	@Autowired
	private CardRepository cR;

	@Override
	public void insert(Card ca) {
		cR.save(ca);
	}

	@Override
	public List<Card> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

	@Override
	public void delete(int id) {
		cR.deleteById(id);
	}
}
