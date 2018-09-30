package sv.com.jvides.models.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the INGRESO_HOSPITALARIO database table.
 * 
 */
@Entity
@Table(name="INGRESO_HOSPITALARIO")
@NamedQuery(name="IngresoHospitalario.findAll", query="SELECT i FROM IngresoHospitalario i")
public class IngresoHospitalario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INGRESO_HOSPITALARIO_IDINGRESO_GENERATOR", sequenceName="OTHER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INGRESO_HOSPITALARIO_IDINGRESO_GENERATOR")
	@Column(name="ID_INGRESO")
	private long idIngreso;

	private BigDecimal alta;

	private BigDecimal estado;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="ID_DOCTOR")
	private BigDecimal idDoctor;

	@ManyToOne
	@JoinColumn(name="ID_CAMA")
	private Camas camas;


	//bi-directional many-to-one association to Pacientes
	@ManyToOne
	@JoinColumn(name="ID_PACIENTE")
	private Pacientes pacientes;

	//bi-directional many-to-one association to Responsable
	@ManyToOne
	@JoinColumn(name="ID_SOLICITUD")
	private Responsable responsable;


	public IngresoHospitalario() {
	}

	public long getIdIngreso() {
		return this.idIngreso;
	}

	public void setIdIngreso(long idIngreso) {
		this.idIngreso = idIngreso;
	}

	public BigDecimal getAlta() {
		return this.alta;
	}

	public void setAlta(BigDecimal alta) {
		this.alta = alta;
	}

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getIdDoctor() {
		return this.idDoctor;
	}

	public void setIdDoctor(BigDecimal idDoctor) {
		this.idDoctor = idDoctor;
	}

	

	public Camas getCama() {
		return this.camas;
	}

	public void setCama(Camas cama) {
		this.camas = camas;
	}

	public Camas getCamas() {
		return camas;
	}

	public void setCamas(Camas camas) {
		this.camas = camas;
	}

	public Pacientes getPacientes() {
		return pacientes;
	}

	public void setPacientes(Pacientes pacientes) {
		this.pacientes = pacientes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Pacientes getPaciente() {
		return this.pacientes;
	}

	public void setPaciente(Pacientes pacientes) {
		this.pacientes = pacientes;
	}

	public Responsable getResponsable() {
		return this.responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

}