package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Card {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_Card;
	@Column(name="Nro_Card", nullable=false, length=50)
	private String Nro_Card;
	private int CVV_Card;
	@Column(name="Expiration_Card", nullable=false, length=50)
	private String Expiration_Card;
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Card(int iD_Card, String nro_Card, int cVV_Card, String expiration_Card) {
		super();
		ID_Card = iD_Card;
		Nro_Card = nro_Card;
		CVV_Card = cVV_Card;
		Expiration_Card = expiration_Card;
	}
	public int getID_Card() {
		return ID_Card;
	}
	public void setID_Card(int iD_Card) {
		ID_Card = iD_Card;
	}
	public String getNro_Card() {
		return Nro_Card;
	}
	public void setNro_Card(String nro_Card) {
		Nro_Card = nro_Card;
	}
	public int getCVV_Card() {
		return CVV_Card;
	}
	public void setCVV_Card(int cVV_Card) {
		CVV_Card = cVV_Card;
	}
	public String getExpiration_Card() {
		return Expiration_Card;
	}
	public void setExpiration_Card(String expiration_Card) {
		Expiration_Card = expiration_Card;
	}
}
