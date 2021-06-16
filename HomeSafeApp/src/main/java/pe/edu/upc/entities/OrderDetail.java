package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_OrderDetail;
	
	@ManyToOne
	@JoinColumn(name = "ID_Order", nullable = false)
	private OrderT ID_Order;
	
	@ManyToOne
	@JoinColumn(name = "ID_Product", nullable = false)
	private Product ID_Product;

	@Pattern(regexp = "[0-9]*", message = "El campo cantidad solo acepta numeros")
	@Size(min = 1, max = 2, message = "La cantidad debe estar en el rango [1;99]")
	@NotEmpty(message = "Ingrese cantidad")
	@Column(name = "Quantity_OrderDetail", nullable = false, length=20)
	private String Quantity_OrderDetail;

	@DecimalMin(value = "0.0", inclusive = true, message = "El descuento mínimo es de 0%")
	@DecimalMax(value = "70.0", inclusive = true, message = "El descuento máximo es de 70%")
	@NotNull(message = "Ingrese Descuento")
	private float Discount_OrderDetail;

	@Column(name = "Notes_OrderDetail", length=50)
	private String Notes_OrderDetail;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(int iD_OrderDetail, OrderT iD_Order, Product iD_Product,
			@Pattern(regexp = "[0-9]*", message = "El campo cantidad solo acepta numeros") @Size(min = 1, max = 2, message = "La cantidad debe estar en el rango [1;99]") @NotEmpty(message = "Ingrese cantidad") String quantity_OrderDetail,
			@DecimalMin(value = "5.0", inclusive = false, message = "El descuento mínimo es de 5%") @DecimalMax(value = "99.0", inclusive = false, message = "El descuento máximo es de 99% soles") @NotNull(message = "Ingrese Descuento") float discount_OrderDetail,
			String notes_OrderDetail) {
		super();
		ID_OrderDetail = iD_OrderDetail;
		ID_Order = iD_Order;
		ID_Product = iD_Product;
		Quantity_OrderDetail = quantity_OrderDetail;
		Discount_OrderDetail = discount_OrderDetail;
		Notes_OrderDetail = notes_OrderDetail;
	}

	public int getID_OrderDetail() {
		return ID_OrderDetail;
	}

	public void setID_OrderDetail(int iD_OrderDetail) {
		ID_OrderDetail = iD_OrderDetail;
	}

	public OrderT getID_Order() {
		return ID_Order;
	}

	public void setID_Order(OrderT iD_Order) {
		ID_Order = iD_Order;
	}

	public Product getID_Product() {
		return ID_Product;
	}

	public void setID_Product(Product iD_Product) {
		ID_Product = iD_Product;
	}

	public String getQuantity_OrderDetail() {
		return Quantity_OrderDetail;
	}

	public void setQuantity_OrderDetail(String quantity_OrderDetail) {
		Quantity_OrderDetail = quantity_OrderDetail;
	}

	public float getDiscount_OrderDetail() {
		return Discount_OrderDetail;
	}

	public void setDiscount_OrderDetail(float discount_OrderDetail) {
		Discount_OrderDetail = discount_OrderDetail;
	}

	public String getNotes_OrderDetail() {
		return Notes_OrderDetail;
	}

	public void setNotes_OrderDetail(String notes_OrderDetail) {
		Notes_OrderDetail = notes_OrderDetail;
	}
	
}
