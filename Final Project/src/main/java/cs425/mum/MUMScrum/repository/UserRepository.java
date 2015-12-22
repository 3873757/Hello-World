package cs425.mum.MUMScrum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cs425.mum.MUMScrum.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
