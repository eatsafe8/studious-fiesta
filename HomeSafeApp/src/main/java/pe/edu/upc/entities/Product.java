package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Product;
	
	@NotEmpty(message="Ingrese nombre")
	@Column(name="Name_Product",length=50, nullable=false)
	private String Name_Product;
	
	@DecimalMin(value="5.0",inclusive = false,message = "El precio mínimo es de 5 soles")
    @DecimalMax(value="1000.0",inclusive = false,message = "El precio máximo es de 1000 soles")
	@NotNull(message="Ingrese precio")
	private float Price_Product;
	
	@Min(value =1,message = "El stock mínimo es de 1")
    @Max(value =100,message = "El stock máximo es de 1")
	@NotNull(message="Ingrese stock")
	private int Stock_Product;
	
	@DecimalMin(value="0.0",inclusive = false,message = "El descuento mínimo es de 0%")
    @DecimalMax(value="70.0",inclusive = false,message = "El descuento máximo es de 70%")
	@NotNull(message="Ingrese descuento")
	private float Discount_Product;
	
	@Column(name="Notes_Product",length=50, nullable=true)
	private String Notes_Product;

	public Product(int iD_Product, String name_Product, float price_Product, int stock_Product, float discount_Product,
			String notes_Product) {
		super();
		ID_Product = iD_Product;
		Name_Product = name_Product;
		Price_Product = price_Product;
		Stock_Product = stock_Product;
		Discount_Product = discount_Product;
		Notes_Product = notes_Product;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getID_Product() {
		return ID_Product;
	}

	public void setID_Product(int iD_Product) {
		ID_Product = iD_Product;
	}

	public String getName_Product() {
		return Name_Product;
	}

	public void setName_Product(String name_Product) {
		Name_Product = name_Product;
	}

	public float getPrice_Product() {
		return Price_Product;
	}

	public void setPrice_Product(float price_Product) {
		Price_Product = price_Product;
	}

	public int getStock_Product() {
		return Stock_Product;
	}

	public void setStock_Product(int stock_Product) {
		Stock_Product = stock_Product;
	}

	public float getDiscount_Product() {
		return Discount_Product;
	}

	public void setDiscount_Product(float discount_Product) {
		Discount_Product = discount_Product;
	}

	public String getNotes_Product() {
		return Notes_Product;
	}

	public void setNotes_Product(String notes_Product) {
		Notes_Product = notes_Product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID_Product;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (ID_Product != other.ID_Product)
			return false;
		return true;
	}
	
	
}
