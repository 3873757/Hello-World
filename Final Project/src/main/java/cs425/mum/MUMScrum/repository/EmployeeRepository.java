package cs425.mum.MUMScrum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cs425.mum.MUMScrum.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
