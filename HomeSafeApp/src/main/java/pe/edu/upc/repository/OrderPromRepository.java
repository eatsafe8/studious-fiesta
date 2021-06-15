package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.OrderProm;

@Repository
public interface OrderPromRepository extends JpaRepository<OrderProm, Integer>{

}
