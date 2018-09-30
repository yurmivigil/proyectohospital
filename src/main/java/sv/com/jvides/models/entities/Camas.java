package sv.com.jvides.models.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CAMAS database table.
 * 
 */
@Entity
@Table(name="CAMAS")
@NamedQuery(name="Cama.findAll", query="SELECT c FROM Camas c")
public class Camas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAMAS_IDCAMA_GENERATOR", sequenceName="OTHER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAMAS_IDCAMA_GENERATOR")
	@Column(name="ID_CAMA")
	private long idCama;

	private BigDecimal estado;

	//bi-directional many-to-one association to IngresoHospitalario
	@OneToMany(mappedBy="camas")
	private List<IngresoHospitalario> ingresoHospitalarios;

	public Camas() {
	}

	public long getIdCama() {
		return this.idCama;
	}

	public void setIdCama(long idCama) {
		this.idCama = idCama;
	}

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public List<IngresoHospitalario> getIngresoHospitalarios() {
		return this.ingresoHospitalarios;
	}

	public void setIngresoHospitalarios(List<IngresoHospitalario> ingresoHospitalarios) {
		this.ingresoHospitalarios = ingresoHospitalarios;
	}

	public IngresoHospitalario addIngresoHospitalario(IngresoHospitalario ingresoHospitalario) {
		getIngresoHospitalarios().add(ingresoHospitalario);
		ingresoHospitalario.setCama(this);

		return ingresoHospitalario;
	}

	public IngresoHospitalario removeIngresoHospitalario(IngresoHospitalario ingresoHospitalario) {
		getIngresoHospitalarios().remove(ingresoHospitalario);
		ingresoHospitalario.setCama(null);

		return ingresoHospitalario;
	}

}