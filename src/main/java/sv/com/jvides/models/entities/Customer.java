package sv.com.jvides.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="customers")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //para mysql
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "customers_Seq")
	@SequenceGenerator(name = "customers_Seq", sequenceName = "CUSTOMERS_SEQ")
	private Long id; 
	
	@Column(name="first_name")
	@NotEmpty
	private String firstName;
	
	@Column(name="last_name")
	@NotEmpty
	private String lastName;
	@NotEmpty
	@Email
	private String email;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createAt;
	//en la tabla facturas va a crear cliente id para relacionar ambas tablas
	@OneToMany(mappedBy="customer", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getCreateAt() {
		return createAt;
	}
	
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	
	
	
	
	
	/*@PrePersist
	public void prePersist() {
	createAt = new Date();
	}*/

}
