package swapi.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import swapi.app.domain.entities.BookingEntity;


@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {
}
