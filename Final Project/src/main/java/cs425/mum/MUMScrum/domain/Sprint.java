package cs425.mum.MUMScrum.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Sprint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	//@Pattern(regexp = "[A-Z][0-9]{2}", message="{validator.sprint.sprintNumber}")
	private String sprintNumber ;
	private String name;
	private Date createdDate;
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "ReleaseId")
	private ProductBackLogRelease release;

	
	@Transient
	private long ReleaseId;
	
	
 	public long getReleaseId() {
		return ReleaseId;
	}

	public void setReleaseId(long releaseId) {
		ReleaseId = releaseId;
	}


//    @OneToMany(mappedBy="sprint", cascade=CascadeType.ALL)
//    private List<UserStorys> userStories;
 	
// 	@Transient
// 	private BurnDownChart burnDownChart = new BurnDownChart();

	public long getId() {
		return id;
	}

	public ProductBackLogRelease getRelease() {
		return release;
	}

	public void setRelease(ProductBackLogRelease release) {
		this.release = release;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSprintNumber() {
		return sprintNumber;
	}

	public void setSprintNumber(String sprintNumber) {
		this.sprintNumber = sprintNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public List<UserStorys> getUserStories() {
//		return userStories;
//	}
//
//	public void setUserStories(List<UserStorys> userStories) {
//		this.userStories = userStories;
//	}

	
//	public void constructBurnDownChart() {
//		return burnDownChart;
//	}
 	

}