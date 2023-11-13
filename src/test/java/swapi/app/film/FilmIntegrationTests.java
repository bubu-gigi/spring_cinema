package swapi.app.film;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import swapi.app.domain.entities.FilmEntity;
import swapi.app.services.FilmService;

@SpringBootTest
public class FilmIntegrationTests {

    @Autowired
    private  FilmService filmService;

    @Test
    void FilmIsCreated() {
        FilmEntity film = FilmEntity.builder()
                .title("FilmTest")
                .status("avaiable")
                .pellicole(17)
                .build();
        FilmEntity tmp = filmService.createFilm(film);
        Integer id = tmp.getId();
        Assertions.assertEquals(film, filmService.getFilm(id).get());
    }
}
