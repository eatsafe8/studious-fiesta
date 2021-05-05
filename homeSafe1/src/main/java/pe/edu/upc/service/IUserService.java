package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.User;

public interface IUserService {
	Integer insert(User user) throws Exception;

	Integer update(User user) throws Exception;

	Integer delete(User user) throws Exception;

	List<User> getAll() throws Exception;

	Optional<User> getOne(User user) throws Exception;

	Optional<User> authentication(User us) throws Exception;
}