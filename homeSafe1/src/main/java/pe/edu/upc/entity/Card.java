package pe.edu.upc.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Card")
public class Card {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_Card;
	private long Nro_Card;
	private int CVV_Card;
	private Date Expiration_Card;
	@ManyToOne
	@JoinColumn(name = "ID_Owner", nullable = true)
	private Owner owner;
	
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Card(int iD_Card, long nro_Card, int cVV_Card, Date expiration_Card, Owner owner) {
		super();
		ID_Card = iD_Card;
		Nro_Card = nro_Card;
		CVV_Card = cVV_Card;
		Expiration_Card = expiration_Card;
		this.owner = owner;
	}

	public int getID_Card() {
		return ID_Card;
	}
	public void setID_Card(int iD_Card) {
		ID_Card = iD_Card;
	}
	public long getNro_Card() {
		return Nro_Card;
	}
	public void setNro_Card(long nro_Card) {
		Nro_Card = nro_Card;
	}
	public int getCVV_Card() {
		return CVV_Card;
	}
	public void setCVV_Card(int cVV_Card) {
		CVV_Card = cVV_Card;
	}
	public Date getExpiration_Card() {
		return Expiration_Card;
	}
	public void setExpiration_Card(Date expiration_Card) {
		Expiration_Card = expiration_Card;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}
