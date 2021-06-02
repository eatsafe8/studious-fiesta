package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Card;

public interface ICardService {
	public void insert(Card ca);

	List<Card> list();

	public void delete(int id);
}
