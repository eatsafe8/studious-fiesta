package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Owner;

public interface IOwnerService {
	public void insert(Owner owner);
	public List<Owner>list();
	public void delete(int ID_Owner);
}
