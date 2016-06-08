package cs425.mum.MUMScrum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cs425.mum.MUMScrum.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
