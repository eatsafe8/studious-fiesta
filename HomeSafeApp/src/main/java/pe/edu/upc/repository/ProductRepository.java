package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import pe.edu.upc.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("select p from Product p where p.nameProduct like %:nameProduct%")
	public List<Product> findByName(String nameProduct);
	
	public List<Product> findByNameProductLikeIgnoreCase(String nameProduct);
	
}
