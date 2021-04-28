package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iD_Product;
	
	@Column(name="name_Product",length=50, nullable=false)
	private String name_Product;
	
	@Column(name="price_Product",length=50, nullable=false)
	private String price_Product;
	
	@Column(name="stock_Product",length=10, nullable=false)
	private int stock_Product;
	
	@Column(name="discount_Product",length=50, nullable=false)
	private String discount_Product;
	
	@Column(name="notes_Product",length=50, nullable=false)
	private String notes_Product;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int iD_Product, String name_Product, String price_Product, int stock_Product,
			String discount_Product, String notes_Product) {
		super();
		this.iD_Product = iD_Product;
		this.name_Product = name_Product;
		this.price_Product = price_Product;
		this.stock_Product = stock_Product;
		this.discount_Product = discount_Product;
		this.notes_Product = notes_Product;
	}

	public int getiD_Product() {
		return iD_Product;
	}

	public void setiD_Product(int iD_Product) {
		this.iD_Product = iD_Product;
	}

	public String getName_Product() {
		return name_Product;
	}

	public void setName_Product(String name_Product) {
		this.name_Product = name_Product;
	}

	public String getPrice_Product() {
		return price_Product;
	}

	public void setPrice_Product(String price_Product) {
		this.price_Product = price_Product;
	}

	public int getStock_Product() {
		return stock_Product;
	}

	public void setStock_Product(int stock_Product) {
		this.stock_Product = stock_Product;
	}

	public String getDiscount_Product() {
		return discount_Product;
	}

	public void setDiscount_Product(String discount_Product) {
		this.discount_Product = discount_Product;
	}

	public String getNotes_Product() {
		return notes_Product;
	}

	public void setNotes_Product(String notes_Product) {
		this.notes_Product = notes_Product;
	}
	
	
}
