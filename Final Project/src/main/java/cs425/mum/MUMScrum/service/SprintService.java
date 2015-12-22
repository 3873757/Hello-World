package cs425.mum.MUMScrum.service;

import java.util.List;

import cs425.mum.MUMScrum.domain.Sprint;

public interface SprintService {
	public void saveSprint(Sprint Sprint);
	public List<Sprint> getAllSprints();
	public Sprint findSprintBySprintNumber(String SprintNumber);
	public Sprint findSprintById(long id);
	public void deleteSprintById(Long id);
}