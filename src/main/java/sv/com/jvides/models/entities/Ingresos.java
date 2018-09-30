package sv.com.jvides.models.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Ingresos")
public class Ingresos  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //para mysql
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ingresos_seq")
	@SequenceGenerator(name = "ingresos_seq", sequenceName = "INGRESOS_SEQ")
	private Long id; 
	
	@Column(name="ID_PACIENTE")
	@NotEmpty
	private String ID_PACIENTE;
	
	@Column(name="ID_DOCTOR")
	@NotEmpty
	private String ID_DOCTOR;
		
	@Column(name="ID_AREA")
	@NotEmpty
	private String ID_AREA;

	@Column(name="ALTA")
	private BigDecimal ALTA;

	public BigDecimal getALTA() {
		return ALTA;
	}

	public void setALTA(BigDecimal aLTA) {
		ALTA = aLTA;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getID_PACIENTE() {
		return ID_PACIENTE;
	}

	public void setID_PACIENTE(String iD_PACIENTE) {
		ID_PACIENTE = iD_PACIENTE;
	}

	public String getID_DOCTOR() {
		return ID_DOCTOR;
	}

	public void setID_DOCTOR(String iD_DOCTOR) {
		ID_DOCTOR = iD_DOCTOR;
	}

	public String getID_AREA() {
		return ID_AREA;
	}

	public void setID_AREA(String iD_AREA) {
		ID_AREA = iD_AREA;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
