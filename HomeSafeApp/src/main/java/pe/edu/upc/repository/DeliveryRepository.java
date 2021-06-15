package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{

	
}
