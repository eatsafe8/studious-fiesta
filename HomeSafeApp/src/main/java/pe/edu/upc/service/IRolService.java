package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Role;

public interface IRolService {
	public void insert(Role role);
	public void delete(int id);

	List<Role> list();

}
