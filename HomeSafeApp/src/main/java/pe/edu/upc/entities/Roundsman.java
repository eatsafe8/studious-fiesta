package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Roundsman")
public class Roundsman {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Roundsman;
	
	@Pattern(regexp = "[0-9]*", message = "El campo DNI solo acepta numeros")
	@Size(min = 8, max = 8, message = "El campo DNI debe tener 8 digitos")
	@NotEmpty(message = "Ingrese DNI")
	@Column(name = "DNI_Roundsman", nullable =false , length=50)
	private String DNI_Roundsman;
	
	@NotEmpty(message = "Ingrese NOMBRE")
	@Column(name = "FirstName_Roundsman", nullable =false , length=50)
	private String FirstName_Roundsman;
	
	@NotEmpty(message = "Ingrese APELLIDO")
	@Column(name = "LastName_Roundsman", nullable =false , length=50)
	private String LastName_Roundsman;
	
	@NotEmpty(message = "Ingrese DIRECCION")
	@Column(name = "Adress_Roundsman", nullable =false , length=50)
	private String Adress_Roundsman;
	
	@Pattern(regexp = "[0-9]*", message = "El campo CELULAR solo acepta numeros")
	@Size(min = 9, max = 9, message = "El campo CELULAR debe tener 9 digitos")
	@NotEmpty(message = "Ingrese CELULAR")
	@Column(name = "Cellphone_Roundsman", nullable =false , length=50)
	private String Cellphone_Roundsman;
	
	@NotEmpty(message = "Ingrese GENERO")
	@Column(name = "Sex_Roundsman", nullable =false , length=50)
	private String Sex_Roundsman;
	
	@NotNull(message = "Ingrese FECHA DE NACIMIENTO")
	@Past(message = "La FECHA DE NACIMIENTO debe ser pasada")
	@Temporal(TemporalType.DATE)
	@Column(name = "DateBirth_Roundsman")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DateBirth_Roundsman;
	
	@NotEmpty(message = "Ingrese ESTADO")
	@Column(name = "StateRoundsman", nullable =false , length=50)
	private String StateRoundsman;
	
	@NotEmpty(message = "Ingrese NOTAS")
	@Column(name = "Notes_Roundsman", nullable =true , length=50)
	private String Notes_Roundsman;

	
	public Roundsman() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roundsman(int iD_Roundsman, String dNI_Roundsman, String firstName_Roundsman, String lastName_Roundsman,
			String adress_Roundsman, String cellphone_Roundsman, String sex_Roundsman, Date dateBirth_Roundsman,
			String stateRoundsman, String notes_Roundsman) {
		super();
		ID_Roundsman = iD_Roundsman;
		DNI_Roundsman = dNI_Roundsman;
		FirstName_Roundsman = firstName_Roundsman;
		LastName_Roundsman = lastName_Roundsman;
		Adress_Roundsman = adress_Roundsman;
		Cellphone_Roundsman = cellphone_Roundsman;
		Sex_Roundsman = sex_Roundsman;
		DateBirth_Roundsman = dateBirth_Roundsman;
		StateRoundsman = stateRoundsman;
		Notes_Roundsman = notes_Roundsman;
	}

	public int getID_Roundsman() {
		return ID_Roundsman;
	}

	public void setID_Roundsman(int iD_Roundsman) {
		ID_Roundsman = iD_Roundsman;
	}

	public String getDNI_Roundsman() {
		return DNI_Roundsman;
	}

	public void setDNI_Roundsman(String dNI_Roundsman) {
		DNI_Roundsman = dNI_Roundsman;
	}

	public String getFirstName_Roundsman() {
		return FirstName_Roundsman;
	}

	public void setFirstName_Roundsman(String firstName_Roundsman) {
		FirstName_Roundsman = firstName_Roundsman;
	}

	public String getLastName_Roundsman() {
		return LastName_Roundsman;
	}

	public void setLastName_Roundsman(String lastName_Roundsman) {
		LastName_Roundsman = lastName_Roundsman;
	}

	public String getAdress_Roundsman() {
		return Adress_Roundsman;
	}

	public void setAdress_Roundsman(String adress_Roundsman) {
		Adress_Roundsman = adress_Roundsman;
	}

	public String getCellphone_Roundsman() {
		return Cellphone_Roundsman;
	}

	public void setCellphone_Roundsman(String cellphone_Roundsman) {
		Cellphone_Roundsman = cellphone_Roundsman;
	}

	public String getSex_Roundsman() {
		return Sex_Roundsman;
	}

	public void setSex_Roundsman(String sex_Roundsman) {
		Sex_Roundsman = sex_Roundsman;
	}

	public Date getDateBirth_Roundsman() {
		return DateBirth_Roundsman;
	}

	public void setDateBirth_Roundsman(Date dateBirth_Roundsman) {
		DateBirth_Roundsman = dateBirth_Roundsman;
	}

	public String getStateRoundsman() {
		return StateRoundsman;
	}

	public void setStateRoundsman(String stateRoundsman) {
		StateRoundsman = stateRoundsman;
	}

	public String getNotes_Roundsman() {
		return Notes_Roundsman;
	}

	public void setNotes_Roundsman(String notes_Roundsman) {
		Notes_Roundsman = notes_Roundsman;
	}
	
	
}
