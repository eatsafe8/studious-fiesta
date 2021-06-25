package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
	@Query(value="select r.name_restaurant, sum(o.price_order*(1-o.discount_price)) from OrderT o join Restaurant r on r.ID_Restaurant=o.ID_Restaurant\r\n"
			+ "where extract(month from o.date_order)=7\r\n"
			+ "group by r.name_restaurant", nativeQuery = true)
	public List<String[]> MontoRestuaranteFiestasPatrias();
}
