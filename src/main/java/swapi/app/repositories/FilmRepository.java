package swapi.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import swapi.app.domain.entities.FilmEntity;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {
    @Query(value = "SELECT * FROM films WHERE status = 'coming_soon'", nativeQuery = true)
    public Iterable<FilmEntity> getComingSoon();

    @Query(value = "SELECT * FROM films WHERE status = 'avaiable'", nativeQuery = true)
    public Iterable<FilmEntity> getAvaiable();

    @Query(value = "SELECT * FROM films WHERE status = 'expired'", nativeQuery = true)
    public Iterable<FilmEntity> getExpired();

    @Query(value = "UPDATE films SET daily_gain = 0", nativeQuery = true)
    public void resetDailyGain();

    @Query(value = "UPDATE films SET weekly_gain = 0", nativeQuery = true)
    public void resetWeeklyGain();

    @Query(value = "UPDATE films SET monthly_gain = 0", nativeQuery = true)
    public void resetMonthlyGain();

    @Query(value = "INSERT INTO report_films_monthly_gain(film_id, monthly_gain) VALUES (:filmId, :monthlyGain)", nativeQuery = true)
    public void saveMonthlyGain(@Param("filmId") Integer filmId, @Param("monthlyGain") double monthlyGain);

    @Query(value = "INSERT INTO report_films_weekly_gain(film_id, weekly_gain) VALUES (:filmId, :weeklyGain)", nativeQuery = true)
    public void saveWeeklyGain(@Param("filmId") Integer filmId, @Param("weeklyGain") double weeklyGain);

    @Query(value = "INSERT INTO report_films_daily_gain(film_id, daily_gain) VALUES (:filmId, :dailyGain)", nativeQuery = true)
    public void saveDailyGain(@Param("filmId") Integer filmId, @Param("dailyGain") double dailyGain);
}
