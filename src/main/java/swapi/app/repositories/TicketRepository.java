package swapi.app.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import swapi.app.domain.entities.TicketEntity;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {

    @Query(value = "SELECT * FROM tickets WHERE film_id = :id", nativeQuery = true)
    Optional<TicketEntity> findByFilmId(@Param("id") Integer id);
}
