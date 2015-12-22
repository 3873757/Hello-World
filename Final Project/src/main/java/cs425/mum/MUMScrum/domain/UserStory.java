package cs425.mum.MUMScrum.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserStory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String userStoryNumber;
	private String name;
	private String description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	
	
}
