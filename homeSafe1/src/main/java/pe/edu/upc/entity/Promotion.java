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
@Table(name = "Promotion")
public class Promotion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Promotion;

	@Column(name = "Name_Promotion", length = 50, nullable = false)
	private String Name_Promotion;

	private float PriceTotal_Promotion;

	private int Stock_Promotion;

	@Column(name = "Notes_Promotion", length = 50, nullable = false)
	private String Notes_Promotion;

	@ManyToOne
	@JoinColumn(name = "ID_Restaurant", nullable = false)
	private Restaurant restaurant;

	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Promotion(int iD_Promotion, String name_Promotion, float priceTotal_Promotion, int stock_Promotion,
			String notes_Promotion, Restaurant restaurant) {
		super();
		ID_Promotion = iD_Promotion;
		Name_Promotion = name_Promotion;
		PriceTotal_Promotion = priceTotal_Promotion;
		Stock_Promotion = stock_Promotion;
		Notes_Promotion = notes_Promotion;
		this.restaurant = restaurant;
	}

	public int getID_Promotion() {
		return ID_Promotion;
	}

	public void setID_Promotion(int iD_Promotion) {
		ID_Promotion = iD_Promotion;
	}

	public String getName_Promotion() {
		return Name_Promotion;
	}

	public void setName_Promotion(String name_Promotion) {
		Name_Promotion = name_Promotion;
	}

	public float getPriceTotal_Promotion() {
		return PriceTotal_Promotion;
	}

	public void setPriceTotal_Promotion(float priceTotal_Promotion) {
		PriceTotal_Promotion = priceTotal_Promotion;
	}

	public int getStock_Promotion() {
		return Stock_Promotion;
	}

	public void setStock_Promotion(int stock_Promotion) {
		Stock_Promotion = stock_Promotion;
	}

	public String getNotes_Promotion() {
		return Notes_Promotion;
	}

	public void setNotes_Promotion(String notes_Promotion) {
		Notes_Promotion = notes_Promotion;
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
		result = prime * result + ID_Promotion;
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
		Promotion other = (Promotion) obj;
		if (ID_Promotion != other.ID_Promotion)
			return false;
		return true;
	}


}
