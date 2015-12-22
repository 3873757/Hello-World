

package cs425.mum.MUMScrum.domain;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ProductBackLogRelease {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private ReleaseBacklog pBacklog;
	
	
	  @OneToMany(mappedBy="release", cascade=CascadeType.ALL)
	  private List<Sprint> Sprints;
	  
	  
	@Transient
	private long productId;
	
	
	private long releaseNumber;
	
	private Date startDate;
	
	
	private Date endDate;
	
	
	@NotEmpty
	private String description;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getreleaseNumber() {
		return releaseNumber;
	}
	public void setreleaseNumber(long releaseNumber) {
		this.releaseNumber = releaseNumber;
	}
	
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public ReleaseBacklog getPBacklog() {
		return pBacklog;
	}


	public void setPBacklog(ReleaseBacklog pBacklog) {
		this.pBacklog = pBacklog;
	}
	public long getproductId() {
		return productId;
	}
	public void setproductId(long productId) {
		this.productId = productId;
	}


	/*@XmlTransient
	public MultipartFile getEmployeeImage() {
		return employeeImage;
	}
	public void setEmployeeImage(MultipartFile employeeImage) {
		this.employeeImage = employeeImage;
	}*/
}
