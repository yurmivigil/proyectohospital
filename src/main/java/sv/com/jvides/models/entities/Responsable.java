package sv.com.jvides.models.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the RESPONSABLE database table.
 *  
 
@Entity
@Table(name="RESPONSABLE")
@NamedQuery(name="Responsable.findAll", query="SELECT r FROM Responsable r")
public class Responsable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESPONSABLE_DUIRESPONSABLE_GENERATOR", sequenceName="OTHER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESPONSABLE_DUIRESPONSABLE_GENERATOR")
	@Column(name="DUI_RESPONSABLE")
	private long duiResponsable;

	private BigDecimal estado;

	@Column(name="NOMBRE_RESPONSABLE")
	private String nombreResponsable;

	private BigDecimal telefono;

	//bi-directional many-to-one association to IngresoHospitalario
	@OneToMany(mappedBy="responsable")
	private List<IngresoHospitalario> ingresoHospitalarios;

	//bi-directional many-to-one association to Paciente
	@OneToMany(mappedBy="responsable")
	private List<Pacientes> pacientes;

	public Responsable() {
	}

	public long getDuiResponsable() {
		return this.duiResponsable;
	}

	public void setDuiResponsable(long duiResponsable) {
		this.duiResponsable = duiResponsable;
	}

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public String getNombreResponsable() {
		return this.nombreResponsable;
	}

	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
	}

	public BigDecimal getTelefono() {
		return this.telefono;
	}

	public void setTelefono(BigDecimal telefono) {
		this.telefono = telefono;
	}

	public List<IngresoHospitalario> getIngresoHospitalarios() {
		return this.ingresoHospitalarios;
	}

	public void setIngresoHospitalarios(List<IngresoHospitalario> ingresoHospitalarios) {
		this.ingresoHospitalarios = ingresoHospitalarios;
	}

	public IngresoHospitalario addIngresoHospitalario(IngresoHospitalario ingresoHospitalario) {
		getIngresoHospitalarios().add(ingresoHospitalario);
		ingresoHospitalario.setResponsable(this);

		return ingresoHospitalario;
	}

	public IngresoHospitalario removeIngresoHospitalario(IngresoHospitalario ingresoHospitalario) {
		getIngresoHospitalarios().remove(ingresoHospitalario);
		ingresoHospitalario.setResponsable(null);

		return ingresoHospitalario;
	}

	public List<Pacientes> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(List<Pacientes> pacientes) {
		this.pacientes = pacientes;
	}
/*
	public Pacientes addPaciente(Pacientes paciente) {
		getPacientes().add(paciente);
		paciente.setResponsable(this);

		return paciente;
	}

	public Pacientes removePaciente(Pacientes paciente) {
		getPacientes().remove(paciente);
		paciente.setResponsable(null);

		return paciente;
	}
 
}*/

@Entity
@NamedQuery(name="Responsable.findAll", query="SELECT r FROM Responsable r")
public class Responsable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DUI_RESPONSABLE")
	private long duiResponsable;

	private BigDecimal estado;

	@Column(name="NOMBRE_RESPONSABLE")
	private String nombreResponsable;

	private BigDecimal telefono;

	//bi-directional many-to-one association to IngresoHospitalario
	@OneToMany(mappedBy="responsable")
	private List<IngresoHospitalario> ingresoHospitalarios;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="ID_PACIENTE")
	private Pacientes paciente;

	private Pacientes pacientes;

	public Responsable() {
	}

	public long getDuiResponsable() {
		return this.duiResponsable;
	}

	public void setDuiResponsable(long duiResponsable) {
		this.duiResponsable = duiResponsable;
	}

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public String getNombreResponsable() {
		return this.nombreResponsable;
	}

	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
	}

	public BigDecimal getTelefono() {
		return this.telefono;
	}

	public void setTelefono(BigDecimal telefono) {
		this.telefono = telefono;
	}

	public List<IngresoHospitalario> getIngresoHospitalarios() {
		return this.ingresoHospitalarios;
	}

	public void setIngresoHospitalarios(List<IngresoHospitalario> ingresoHospitalarios) {
		this.ingresoHospitalarios = ingresoHospitalarios;
	}

	public IngresoHospitalario addIngresoHospitalario(IngresoHospitalario ingresoHospitalario) {
		getIngresoHospitalarios().add(ingresoHospitalario);
		ingresoHospitalario.setResponsable(this);

		return ingresoHospitalario;
	}

	public IngresoHospitalario removeIngresoHospitalario(IngresoHospitalario ingresoHospitalario) {
		getIngresoHospitalarios().remove(ingresoHospitalario);
		ingresoHospitalario.setResponsable(null);

		return ingresoHospitalario;
	}

	public Pacientes getPacientes() {
		return this.getPacientes();
	}

	public void setPacientes(Pacientes pacientes) {
		this.pacientes = pacientes;
	}}