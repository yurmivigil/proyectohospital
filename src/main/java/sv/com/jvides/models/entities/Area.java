package sv.com.jvides.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="area")
public class Area implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "area_Seq")
	@SequenceGenerator(name = "area_Seq", sequenceName = "ID_AREA")
	private Long id; 
	
	@Column(name="NOM_AREA")
	@NotEmpty
	private String NOM_AREA;
	
	@Column(name="DES_AREA")
	@NotEmpty

	@NotEmpty
	private String DES_AREA;
	@NotEmpty
	private String ESTADO;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNOM_AREA() {
		return NOM_AREA;
	}
	public void setNOM_AREA(String nOM_AREA) {
		NOM_AREA = nOM_AREA;
	}
	public String getDES_AREA() {
		return DES_AREA;
	}
	public void setDES_AREA(String dES_AREA) {
		DES_AREA = dES_AREA;
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
