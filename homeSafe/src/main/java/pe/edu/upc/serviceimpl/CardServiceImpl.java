package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ICardDao;
import pe.edu.upc.entity.Card;
import pe.edu.upc.service.ICardService;

@Named
@RequestScoped
public class CardServiceImpl implements ICardService{
	@Inject	
	private ICardDao cdDao;

public void insert(Card card) {
	// TODO Auto-generated method stub
	cdDao.insert(card);
}

public List<Card> list() {
	return cdDao.list();
}

public void delete(int ID_Card) {
	cdDao.delete(ID_Card);
}
}
