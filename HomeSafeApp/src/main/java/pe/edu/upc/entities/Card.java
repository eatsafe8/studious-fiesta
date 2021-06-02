package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Card")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Card;

	@Digits(integer = 16, fraction = 0)
	@Size(min = 16, max = 16)
	@Column(name = "Nro_Card", nullable = false, length = 16)
	private String Nro_Card;

	@Digits(integer = 3, fraction = 0)
	@Column(name = "CVV_CVC_Card", nullable = false, length = 3)
	private int CVV_CVC_Card;

	@NotNull(message = "Ingrese la fecha de expiración")
	@Future(message = "La fecha de expiración debe ser mayor a la fecha actual")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Expiration_Card")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date Expiration_Card;

	@ManyToOne
	@JoinColumn(name = "ID_Owner", nullable = false)
	private Owner ID_Owner;

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(int iD_Card, @Digits(integer = 16, fraction = 0) @Size(min = 16, max = 16) String nro_Card,
			@Digits(integer = 3, fraction = 0) @Size(min = 3, max = 3) int cVV_CVC_Card,
			@NotNull(message = "Ingrese la fecha") @Past(message = "La fecha debe ser pasada") Date expiration_Card,
			Owner iD_Owner) {
		super();
		ID_Card = iD_Card;
		Nro_Card = nro_Card;
		CVV_CVC_Card = cVV_CVC_Card;
		Expiration_Card = expiration_Card;
		ID_Owner = iD_Owner;
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

	public int getCVV_CVC_Card() {
		return CVV_CVC_Card;
	}

	public void setCVV_CVC_Card(int cVV_CVC_Card) {
		CVV_CVC_Card = cVV_CVC_Card;
	}

	public Date getExpiration_Card() {
		return Expiration_Card;
	}

	public void setExpiration_Card(Date expiration_Card) {
		Expiration_Card = expiration_Card;
	}

	public Owner getID_Owner() {
		return ID_Owner;
	}

	public void setID_Owner(Owner iD_Owner) {
		ID_Owner = iD_Owner;
	}
}
