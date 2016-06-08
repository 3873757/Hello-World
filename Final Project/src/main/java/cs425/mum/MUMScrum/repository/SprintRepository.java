package cs425.mum.MUMScrum.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cs425.mum.MUMScrum.domain.Sprint;

@Repository
public interface SprintRepository extends CrudRepository<Sprint, Long> {
	@Query("select s  from Sprint  s where s.sprintNumber= :sprintNumber")
	public Sprint findSprintBySprintNumber(@Param("sprintNumber") String sprintNumber);
}