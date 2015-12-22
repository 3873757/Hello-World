

package cs425.mum.MUMScrum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cs425.mum.MUMScrum.domain.ProductBackLogRelease;

@Repository
public interface ReleaseRepository extends CrudRepository<ProductBackLogRelease, Long> {

}
