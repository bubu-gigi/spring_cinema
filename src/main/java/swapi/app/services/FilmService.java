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
    void resetDailyGain();
    void resetWeeklyGain();
    void resetMonthlyGain();
    void saveReportMonthlyGain(Integer filmId, double monthlyGain);
    void saveReportWeeklyGain(Integer filmId, double weeklyGain);
    void saveReportDailyGain(Integer filmId, double dailyGain);
}
