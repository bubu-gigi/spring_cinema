package swapi.app.services.impl;

import org.springframework.stereotype.Component;
import swapi.app.domain.entities.FilmEntity;
import swapi.app.repositories.FilmRepository;
import swapi.app.services.FilmService;

import java.util.List;
import java.util.Optional;


@Component
public class FilmServiceImpl implements FilmService {

    private FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Iterable<FilmEntity> getFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Optional<FilmEntity> getFilm(Integer id) {
        return filmRepository.findById(id);
    }

    @Override
    public FilmEntity createFilm(FilmEntity film) {
        return filmRepository.save(film);
    }

    @Override
    public Iterable<FilmEntity> getComingSoon() {
        return filmRepository.getComingSoon();
    }

    @Override
    public Iterable<FilmEntity> getAvaiable() {
        return filmRepository.getAvaiable();
    }

    @Override
    public Iterable<FilmEntity> getExpired() {
        return filmRepository.getExpired();
    }

}
