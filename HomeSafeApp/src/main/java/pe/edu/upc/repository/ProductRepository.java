package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
