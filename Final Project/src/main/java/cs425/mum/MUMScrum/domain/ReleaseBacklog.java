package cs425.mum.MUMScrum.domain;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class ReleaseBacklog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
		
	private String productId;
	
	
	private String name;
	
	
	private String description;
	
	private Date dateCreated;
	
	 
//    @OneToMany(mappedBy="productBacklog", cascade=CascadeType.ALL)
//    private List<UserStorys> userStories;
//
//    @OneToMany(mappedBy="productBacklog", cascade=CascadeType.ALL)
//    private List<ProductBackLogRelease> ProductBackLogReleases;
//    
    
    
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/*public Employee getProductOwner() {
		return productOwner;
	}
	public void setProductOwner(Employee productOwner) {
		this.productOwner = productOwner;
	}
	public List<ReleaseBacklog> getReleaseBacklog() {
		return releaseBacklog;
	}
	public void setReleaseBacklog(List<ReleaseBacklog> releaseBacklog) {
		this.releaseBacklog = releaseBacklog;
	}
	*/
	
//	public List<ProductBackLogRelease> getReleaseBacklog() {
//		return ProductBackLogReleases;
//	}
//	public void setReleaseBacklog(List<ProductBackLogRelease> releaseBacklog) {
//		this.ProductBackLogReleases = releaseBacklog;
//	}
//	
//	
//	public List<UserStorys> getUserStories() {
//		return userStories;
//	}
//	public void setUserStories(List<UserStorys> userStories) {
//		this.userStories = userStories;
//	}
	
}