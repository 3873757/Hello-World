
package cs425.mum.MUMScrum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cs425.mum.MUMScrum.domain.Employee;
import cs425.mum.MUMScrum.domain.ReleaseBacklog;

@Repository
public interface ProductBacklogRepository extends CrudRepository<ReleaseBacklog, Long> {

}
