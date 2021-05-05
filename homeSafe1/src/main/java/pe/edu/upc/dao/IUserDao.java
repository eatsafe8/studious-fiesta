package pe.edu.upc.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.User;

public interface IUserDao {
	Integer insert(User user) throws Exception;

	Integer update(User user) throws Exception;

	Integer delete(User user) throws Exception;

	List<User> findAll() throws Exception;

	Optional<User> findById(User user) throws Exception;

	String getPassworHashedByUserName(String username) throws Exception;

	Optional<User> findUserByUsername(User user) throws Exception;
}
