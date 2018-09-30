package sv.com.jvides.models.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="RECETAS")
@NamedQuery(name="Receta.findAll", query="SELECT r FROM Receta r")
public class Receta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RECETAS_IDRECETA_GENERATOR", sequenceName="OTHER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RECETAS_IDRECETA_GENERATOR")
	
	@Column(name="idReceta")
	private long idReceta;

	@Column(name="descripcion")
	private String descripcion;


	@Column(name="doctorxingreso")
	private BigDecimal doctorxingreso;
	
	@Column(name="dui")
	private String dui;

	//bi-directional many-to-one association to Medicamento
	
	@Column(name="ID_MEDICAMENTO")
	private String medicamento;

	public long getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(long idReceta) {
		this.idReceta = idReceta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getDoctorxingreso() {
		return doctorxingreso;
	}

	public void setDoctorxingreso(BigDecimal doctorxingreso) {
		this.doctorxingreso = doctorxingreso;
	}

	public String getDui() {
		return dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
	
}