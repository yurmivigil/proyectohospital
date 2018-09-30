package sv.com.jvides.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Doctores")
public class Doctores implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //para mysql
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "doctores_Seq")
	@SequenceGenerator(name = "doctores_Seq", sequenceName = "DOCTORES_SEQ")
	private Long id; 
	
	@Column(name="NOM_DOCTOR")
	@NotEmpty
	private String NOM_DOCTOR;
	
	@Column(name="APE_DOCTOR")
	@NotEmpty
	private String APE_DOCTOR;
		
	@Column(name="ESTADO")
	@NotEmpty
	private String ESTADO;
	
	@Column(name="ID_TURNO")
	private Long ID_TURNO;
	

	public Long getID_TURNO() {
		return ID_TURNO;
	}

	public void setID_TURNO(Long iD_TURNO) {
		ID_TURNO = iD_TURNO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNOM_DOCTOR() {
		return NOM_DOCTOR;
	}

	public void setNOM_DOCTOR(String nOM_DOCTOR) {
		NOM_DOCTOR = nOM_DOCTOR;
	}

	public String getAPE_DOCTOR() {
		return APE_DOCTOR;
	}

	public void setAPE_DOCTOR(String aPE_DOCTOR) {
		APE_DOCTOR = aPE_DOCTOR;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
