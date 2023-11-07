package swapi.app.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import swapi.app.domain.entities.FilmEntity;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<FilmEntity, Integer> {
    @Query(value = "SELECT * FROM films WHERE status = 'coming_soon'", nativeQuery = true)
    public Iterable<FilmEntity> getComingSoon();

    @Query(value = "SELECT * FROM films WHERE status = 'avaiable'", nativeQuery = true)
    public Iterable<FilmEntity> getAvaiable();

    @Query(value = "SELECT * FROM films WHERE status = 'expired'", nativeQuery = true)
    public Iterable<FilmEntity> getExpired();
}
