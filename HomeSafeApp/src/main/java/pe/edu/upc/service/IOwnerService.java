package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Owner;

public interface IOwnerService {
	public void insert(Owner ow);

	List<Owner> list();

	public void delete(int id);
}
