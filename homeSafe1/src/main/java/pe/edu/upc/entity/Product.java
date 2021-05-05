package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Product;
	@Column(name="Name_Product",length=50, nullable=false)
	private String Name_Product;
	private float Price_Product;
	private int Stock_Product;
	private float Discount_Product;
	@Column(name="Notes_Product",length=50, nullable=false)
	private String Notes_Product;
	@ManyToOne
	@JoinColumn(name = "ID_Restaurant", nullable = false)
	private Restaurant restaurant;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(int iD_Product, String name_Product, float price_Product, int stock_Product,
			float discount_Product, String notes_Product, Restaurant restaurant) {
		super();
		ID_Product = iD_Product;
		Name_Product = name_Product;
		Price_Product = price_Product;
		Stock_Product = stock_Product;
		Discount_Product = discount_Product;
		Notes_Product = notes_Product;
		this.restaurant = restaurant;
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

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
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
