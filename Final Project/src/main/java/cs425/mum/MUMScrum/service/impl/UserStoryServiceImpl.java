package cs425.mum.MUMScrum.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cs425.mum.MUMScrum.domain.UserStorys;
import cs425.mum.MUMScrum.repository.UserStoryRepository;
import cs425.mum.MUMScrum.service.UserStoryService;

@Service
@Transactional
public class UserStoryServiceImpl implements UserStoryService {

	@Autowired
	UserStoryRepository userStoryRepository;

	@Override
	public List<UserStorys> getAllUserStories() {
		// TODO Auto-generated method stub
		return (List<UserStorys>) this.userStoryRepository.findAll();
	}

	@Override
	public UserStorys getUserStoryId(long id) {
		// TODO Auto-generated method stub
		return this.userStoryRepository.findOne(id);
	}

	@Override
	public void deletegetUserStoryId(long id) {
		// TODO Auto-generated method stub
		this.userStoryRepository.delete(id);

	}

	@Override
	public void saveUserStory(UserStorys userStory) {
		// TODO Auto-generated method stub
		this.userStoryRepository.save(userStory);

	}

}
