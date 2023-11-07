package swapi.app.services;

import org.springframework.stereotype.Service;
import swapi.app.domain.entities.FilmEntity;

import java.util.Optional;


@Service
public interface FilmService {
    Iterable<FilmEntity> getFilms();
    Optional<FilmEntity> getFilm(Integer id);
    Iterable<FilmEntity> getComingSoon();
    Iterable<FilmEntity> getAvaiable();
    Iterable<FilmEntity> getExpired();
    FilmEntity createFilm(FilmEntity film);
}
