package sv.com.jvides.models.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the MEDICAMENTO database table.
 * 
 */
@Entity
@NamedQuery(name="Medicamento.findAll", query="SELECT m FROM Medicamento m")
public class Medicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MEDICAMENTO_ID_GENERATOR", sequenceName="OTHER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEDICAMENTO_ID_GENERATOR")
	@Column(name="ID")
	private long id;

	private BigDecimal estado;

	private BigDecimal existencias;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_VENCIMIENTO")
	private Date fechaVencimiento;

	private String laboratorio;

	private String lote;

	@Column(name="NOMBRE_MED")
	private String nombreMed;

	//bi-directional many-to-one association to Receta
	@OneToMany(mappedBy="medicamento")
	private List<Receta> recetas;

	public Medicamento() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public BigDecimal getExistencias() {
		return this.existencias;
	}

	public void setExistencias(BigDecimal existencias) {
		this.existencias = existencias;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getLaboratorio() {
		return this.laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public String getLote() {
		return this.lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getNombreMed() {
		return this.nombreMed;
	}

	public void setNombreMed(String nombreMed) {
		this.nombreMed = nombreMed;
	}

	public List<Receta> getRecetas() {
		return this.recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

	
	}
	


