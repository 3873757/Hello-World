package cs425.mum.MUMScrum.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	@Pattern(regexp="[A-Z]{1}[0-9]{5}",message="{validator.employee.constrain.number}")
	private String number;
	
	@NotEmpty
	@Pattern(regexp="[a-zA-Z]{2,50}", message="{validator.employee.character.firstName}")
	private String firstName;
	
	@NotEmpty
	@Pattern(regexp="[a-zA-Z]{2,50}", message="{validator.employee.character.lastName}")
	private String lastName;
	
	private Date dateOfBirth;
	
	@NotNull
	@DecimalMin(value = "100", message = "{validator.employee.baseSalary}")
	@DecimalMax(value = "1000000", message = "{validator.employee.baseSalary}")
	private double baseSalary;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Pattern(regexp="[\\d]{3}-[\\d]{3,4}-[\\d]{4}", message="{validator.employee.phone}")
	private String phone;
	
	@Valid
	@OneToOne(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	/*@JsonIgnore
	@Transient
	private MultipartFile  employeeImage;*/
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/*@XmlTransient
	public MultipartFile getEmployeeImage() {
		return employeeImage;
	}
	public void setEmployeeImage(MultipartFile employeeImage) {
		this.employeeImage = employeeImage;
	}*/
}
