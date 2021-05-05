package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Owner;

public interface IOwnerDao {
	public void insert(Owner owner);
	public List<Owner>list();
	public void delete(int ID_Owner);
}
