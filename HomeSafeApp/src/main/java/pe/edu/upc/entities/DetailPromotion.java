package pe.edu.upc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "DetailPromotion")
public class DetailPromotion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_DetailPromotion;

	@Min(value = 1, message = "El valor mínimo es de 1")
	@NotNull(message = "Ingrese cantidad")
	private int Quantity_DetailPromotion;

	@ManyToOne
	@JoinColumn(name = "ID_Promotion", nullable = false)
	private Promotion promotion;

	@ManyToOne
	@JoinColumn(name = "ID_Product", nullable = false)
	private Product product;

	public DetailPromotion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getID_DetailPromotion() {
		return ID_DetailPromotion;
	}

	public void setID_DetailPromotion(int iD_DetailPromotion) {
		ID_DetailPromotion = iD_DetailPromotion;
	}

	public int getQuantity_DetailPromotion() {
		return Quantity_DetailPromotion;
	}

	public void setQuantity_DetailPromotion(int quantity_DetailPromotion) {
		Quantity_DetailPromotion = quantity_DetailPromotion;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public DetailPromotion(int iD_DetailPromotion,
			@Min(value = 1, message = "El valor mínimo es de 1") @NotNull(message = "Ingrese cantidad") int quantity_DetailPromotion,
			Promotion promotion, Product product) {
		super();
		ID_DetailPromotion = iD_DetailPromotion;
		Quantity_DetailPromotion = quantity_DetailPromotion;
		this.promotion = promotion;
		this.product = product;
	}
	
}
