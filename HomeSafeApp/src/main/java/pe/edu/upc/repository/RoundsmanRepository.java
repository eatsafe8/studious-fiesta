package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Roundsman;

@Repository
public interface RoundsmanRepository extends JpaRepository<Roundsman, Integer>{
	@Query( value="SELECT rp.first_name_roundsman, rp.last_name_roundsman, count(de.id_delivery) from Roundsman rp join Delivery de on de.ID_Roundsman = rp.ID_Roundsman group by rp.first_name_roundsman, rp.last_name_roundsman",
			nativeQuery = true )
	public List<String[]> DeliveriesXRoundsman();
}
