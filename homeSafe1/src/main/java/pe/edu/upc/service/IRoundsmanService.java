package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Roundsman;

public interface IRoundsmanService {
	public void insert(Roundsman roundsman);
	
	public List<Roundsman> list();
	
	public void delete(int ID_Roundsman);
}
