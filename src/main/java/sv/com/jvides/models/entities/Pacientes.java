package sv.com.jvides.models.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PACIENTES database table.
 * 
 */
@Entity
@Table(name="PACIENTES")
@NamedQuery(name="Pacientes.findAll", query="SELECT p FROM Pacientes p")
public class Pacientes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PACIENTES_DUI_GENERATOR", sequenceName="OTHER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PACIENTES_DUI_GENERATOR")
	private long dui;

	private String apellido;

	private String direccion;

	private BigDecimal estado;

	@Column(name="NOM_MADRE")
	private String nomMadre;

	@Column(name="NOM_PADRE")
	private String nomPadre;

	private String nombre;

	@Column(name="T_SANGRE")
	private String tSangre;

	private String telefono;

	//bi-directional many-to-one association to IngresoHospitalario
	@OneToMany(mappedBy="pacientes")
	private List<IngresoHospitalario> ingresoHospitalarios;

	/*
	//bi-directional many-to-one association to Responsable
	@ManyToOne
	@JoinColumn(name="ID_REFERENCIA")
	private Responsable responsable;
*/
	public Pacientes() {
	}

	public long getDui() {
		return this.dui;
	}

	public void setDui(long dui) {
		this.dui = dui;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public String getNomMadre() {
		return this.nomMadre;
	}

	public void setNomMadre(String nomMadre) {
		this.nomMadre = nomMadre;
	}

	public String getNomPadre() {
		return this.nomPadre;
	}

	public void setNomPadre(String nomPadre) {
		this.nomPadre = nomPadre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTSangre() {
		return this.tSangre;
	}

	public void setTSangre(String tSangre) {
		this.tSangre = tSangre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
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
		ingresoHospitalario.setPaciente(this);

		return ingresoHospitalario;
	}

	public IngresoHospitalario removeIngresoHospitalario(IngresoHospitalario ingresoHospitalario) {
		getIngresoHospitalarios().remove(ingresoHospitalario);
		ingresoHospitalario.setPaciente(null);

		return ingresoHospitalario;
	}

/*

	public Responsable getResponsable() {
		return this.responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
*/
}