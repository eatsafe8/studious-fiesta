package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Roundsman;

public interface IRoundsmanDao {
	
	public void insert(Roundsman roundsman);
	
	public List<Roundsman> list();
	
	public void delete(int ID_Roundsman);
}
