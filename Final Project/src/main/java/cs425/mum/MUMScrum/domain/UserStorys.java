
package cs425.mum.MUMScrum.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import cs425.mum.MUMScrum.domain.ProductBackLogRelease;

@Entity
public class UserStorys {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String userStoryNumber;

	private String name;

	private String description;

	private double initialTestEffort;

	private double initialDevelopmentEffort;

	private double currentTestEffort;

	private double currentDevelopmentEffort;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public ReleaseBacklog getProductBacklog() {
		return productBacklog;
	}

	public void setProductBacklog(ReleaseBacklog productBacklog) {
		this.productBacklog = productBacklog;
	}

	public void setCurrentDevelopmentEffort(double currentDevelopmentEffort) {
		this.currentDevelopmentEffort = currentDevelopmentEffort;
	}

	private Date createdDate;

	private Date startDate;

	private Date dueDate;

	
	@ManyToOne(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
	private ReleaseBacklog productBacklog;

	@ManyToOne(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
	private ProductBackLogRelease productBacklogRelease;

	@ManyToOne(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
	private Sprint sprint;

	
	@ManyToOne
	@JoinColumn(name = "sprint_id")
	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprints) {
		this.sprint = sprints;
	}

	public ProductBackLogRelease getProductBacklogRelease() {
		return productBacklogRelease;
	}

	public void setProductBacklogRelease(ProductBackLogRelease productBacklogRelease) {
		this.productBacklogRelease = productBacklogRelease;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public ProductBackLogRelease getProductBacklogRelease() {
//		return productBacklogRelease;
//	}
//
//	public void setProductBacklogRelease(ProductBackLogRelease productBacklogRelease) {
//		this.productBacklogRelease = productBacklogRelease;
//	}

	public String getUserStoryNumber() {
		return userStoryNumber;
	}

	public void setUserStoryNumber(String userStoryNumber) {
		this.userStoryNumber = userStoryNumber;
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

	public double getInitialTestEffort() {
		return initialTestEffort;
	}

	public void setInitialTestEffort(double initialTestEffort) {
		this.initialTestEffort = initialTestEffort;
	}

	public double getInitialDevelopmentEffort() {
		return initialDevelopmentEffort;
	}

	public void setInitialDevelopmentEffort(double initialDevelopmentEffort) {
		this.initialDevelopmentEffort = initialDevelopmentEffort;
	}

	public double getCurrentTestEffort() {
		return currentTestEffort;
	}

	public void setCurrentTestEffort(double currentTestEffort) {
		this.currentTestEffort = currentTestEffort;
	}

	public double getCurrentDevelopmentEffort() {
		return currentDevelopmentEffort;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}