package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.DetailPromotion;

@Repository
public interface DetailPromotionRepository extends JpaRepository<DetailPromotion, Integer>{

}
