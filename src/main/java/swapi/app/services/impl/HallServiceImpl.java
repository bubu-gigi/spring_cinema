package swapi.app.services.impl;

import org.springframework.stereotype.Component;
import swapi.app.domain.entities.HallEntity;
import swapi.app.repositories.HallRepository;
import swapi.app.services.HallService;

import java.util.Optional;


@Component
public class HallServiceImpl implements HallService {

    private final HallRepository hallRepository;

    public HallServiceImpl(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    public Iterable<HallEntity> getHalls() {
        return hallRepository.findAll();
    }

    public Optional<HallEntity> getHall(Integer id) {
        return hallRepository.findById(id);
    }

    public HallEntity createHall(HallEntity hall) {
        return hallRepository.save(hall);
    }
    public void deleteById(Integer id){ hallRepository.deleteById(id); }
    public void resetBaseSeats(){
        hallRepository.resetBaseSeats();
    }
    public void resetVipSeats(){
        hallRepository.resetVipSeats();
    }
}
