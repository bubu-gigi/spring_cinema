package swapi.app.services.impl;

import org.springframework.stereotype.Component;
import swapi.app.domain.entities.HallEntity;
import swapi.app.repositories.HallRepository;
import swapi.app.services.HallService;

import java.util.Optional;


@Component
public class HallServiceImpl implements HallService {

    final HallRepository hallRepository;

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
}
