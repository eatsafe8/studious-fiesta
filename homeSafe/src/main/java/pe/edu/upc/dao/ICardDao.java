package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Card;

public interface ICardDao {
	public void insert(Card card);
	public List<Card>list();
	public void delete(int ID_Card);
}
