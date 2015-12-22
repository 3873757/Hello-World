package cs425.mum.MUMScrum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cs425.mum.MUMScrum.domain.UserStorys;

@Service
public interface UserStoryService {
	
	public List<UserStorys> getAllUserStories();
	public UserStorys getUserStoryId(long id);
	public void deletegetUserStoryId(long id);
	public void saveUserStory(UserStorys userStory);

}