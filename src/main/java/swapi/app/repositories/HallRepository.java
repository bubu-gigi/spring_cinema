package swapi.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import swapi.app.domain.entities.HallEntity;

import java.util.Optional;


@Repository
public interface HallRepository extends JpaRepository<HallEntity, Integer> {

    @Query(value = "SELECT * FROM halls WHERE hall_id = :id", nativeQuery = true)
    public Optional<HallEntity> findByFilmId(@Param("id") Integer id);

    @Query(value = "UPDATE halls SET sold_base_seats = 0", nativeQuery = true)
    public void resetBaseSeats();

    @Query(value = "UPDATE halls SET sold_vip_seats = 0", nativeQuery = true)
    public void resetVipSeats();
}
