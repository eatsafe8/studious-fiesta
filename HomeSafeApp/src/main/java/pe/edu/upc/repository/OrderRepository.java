package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.OrderT;

@Repository
public interface OrderRepository extends JpaRepository<OrderT, Integer>{

}
