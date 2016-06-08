package cs425.mum.MUMScrum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs425.mum.MUMScrum.domain.Sprint;
import cs425.mum.MUMScrum.repository.SprintRepository;
import cs425.mum.MUMScrum.service.SprintService;


@Service
@Transactional 
public class SprintServiceImpl implements SprintService {
	
 	@Autowired
	private SprintRepository sprintRepository;
 	
	public void saveSprint(Sprint sprint) {
		sprintRepository.save(sprint);
	}
	public List<Sprint> getAllSprints() {
		return (List<Sprint>)sprintRepository.findAll();
	}

	public Sprint findSprintBySprintNumber(String SprintNumber) {
		return sprintRepository.findSprintBySprintNumber(SprintNumber);
	}
	@Override
	public Sprint findSprintById(long id) {
		return sprintRepository.findOne(id);
	}
	
	@Override
	public void deleteSprintById(Long id) {
		sprintRepository.delete(id);
	}
}