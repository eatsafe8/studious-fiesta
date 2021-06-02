package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

}
