package swapi.app.services;

import org.springframework.stereotype.Service;
import swapi.app.domain.entities.HallEntity;

import java.util.Optional;


@Service
public interface HallService {
    Iterable<HallEntity> getHalls();

    Optional<HallEntity> getHall(Integer id);
    HallEntity createHall(HallEntity hall);
    void deleteById(Integer id);
    void resetBaseSeats();
    void resetVipSeats();

}
