package swapi.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import swapi.app.domain.entities.HallEntity;


@Repository
public interface HallRepository extends CrudRepository<HallEntity, Integer> {
}
