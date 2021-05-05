package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Card;

public interface ICardService {
	public void insert(Card card);
	public List<Card>list();
	public void delete(int ID_Card);
}
