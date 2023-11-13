package swapi.app.schedulers;


import org.springframework.scheduling.annotation.Scheduled;
import swapi.app.domain.entities.FilmEntity;
import swapi.app.services.FilmService;

import java.util.Iterator;

public class FilmScheduler {
    private final FilmService filmService;

    public FilmScheduler(FilmService filmService) {
        this.filmService = filmService;
    }

    @Scheduled(cron = "0 0 4 * * ?")
    public void resetDailyGain() {
        Iterable<FilmEntity> films = filmService.getFilms();
        Iterator<FilmEntity> it = films.iterator();
        while(it.hasNext()) {
            filmService.saveReportDailyGain(it.next().getId(), it.next().getDailyGain());
        }
        filmService.resetDailyGain();
    }

    @Scheduled(cron = "0 15 4 ? * MON")
    public void resetWeeklyGain() {
        Iterable<FilmEntity> films = filmService.getFilms();
        Iterator<FilmEntity> it = films.iterator();
        while(it.hasNext()) {
            filmService.saveReportWeeklyGain(it.next().getId(), it.next().getWeeklyGain());
        }
        filmService.resetWeeklyGain();
    }

    @Scheduled(cron = "0 30 4 1 * ?")
    public void resetMonthlyGain() {
        Iterable<FilmEntity> films = filmService.getFilms();
        Iterator<FilmEntity> it = films.iterator();
        while(it.hasNext()) {
        filmService.saveReportMonthlyGain(it.next().getId(), it.next().getMonthlyGain());
        }
        filmService.resetMonthlyGain();
    }
}
