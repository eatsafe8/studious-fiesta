package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer>{

}