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
	
	@Query( value="SELECT pr.name_product,sum(ide.quantity_order_detail) from OrderT i join order_detail ide on ide.ID_Order = i.ID_Order join Product pr on ide.ID_Product = pr.ID_Product group by pr.name_product",
			nativeQuery = true )
	public List<String[]> prodXord();
	
	@Query(value="select distinct pr.name_product, r.name_restaurant from order_detail od inner join Product pr on od.ID_Product=pr.ID_Product join ordert o on o.ID_Order=od.ID_Order join restaurant r on r.ID_Restaurant=pr.ID_Restaurant where o.date_order between '2022-01-01' and '2022-06-30'",
			nativeQuery=true)
	public List<String[]> ProdVendPrim6Mes();
	
}
