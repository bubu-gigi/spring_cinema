package swapi.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swapi.app.domain.dto.FilmDto;
import swapi.app.domain.entities.FilmEntity;
import swapi.app.mappers.Mapper;
import swapi.app.services.FilmService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class FilmController {


    private final FilmService filmService;

    private final Mapper<FilmEntity, FilmDto> filmMapper;

    public FilmController(FilmService filmService, Mapper<FilmEntity, FilmDto> filmMapper) {
        this.filmService = filmService;
        this.filmMapper = filmMapper;
    }

    /** funziona **/
    @PostMapping(path = "/api/films")
    public ResponseEntity<FilmDto> postFilm(@RequestBody FilmDto film) {
        FilmEntity filmEn = filmMapper.mapFrom(film);
        filmService.createFilm(filmEn);
        return new ResponseEntity<>(filmMapper.mapTo(filmEn), HttpStatus.CREATED);
    }

    /** funziona **/
    @GetMapping(path = "/api/films")
    public List<FilmDto> show() {
        Iterable<FilmEntity> films = filmService.getFilms();
        Iterator<FilmEntity> it = films.iterator();
        List<FilmDto> list = new ArrayList<>();
        while(it.hasNext())
            list.add(filmMapper.mapTo(it.next()));
        return list;
    }

    @GetMapping(path = "/api/films/{id}")
    public ResponseEntity<FilmDto> getFilm (@PathVariable("id") Integer id) {
        Optional<FilmEntity> film = filmService.getFilm(id);
        if(film.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(filmMapper.mapTo(film.get()), HttpStatus.CREATED);
    }

    @GetMapping(path = "/api/films/coming-soon")
    public List<FilmDto> getComingSoon() {
        Iterable<FilmEntity> films = filmService.getComingSoon();
        Iterator<FilmEntity> it = films.iterator();
        List<FilmDto> list = new ArrayList<>();
        while(it.hasNext())
            list.add(filmMapper.mapTo(it.next()));
        return list;
    }

    @GetMapping(path = "/api/films/avaiable")
    public List<FilmDto> getAvaiable() {
        Iterable<FilmEntity> films = filmService.getAvaiable();
        Iterator<FilmEntity> it = films.iterator();
        List<FilmDto> list = new ArrayList<>();
        while(it.hasNext())
            list.add(filmMapper.mapTo(it.next()));
        return list;
    }

    @GetMapping(path = "/api/films/expired")
    public List<FilmDto> getExpired() {
        Iterable<FilmEntity> films = filmService.getExpired();
        Iterator<FilmEntity> it = films.iterator();
        List<FilmDto> list = new ArrayList<>();
        while(it.hasNext())
            list.add(filmMapper.mapTo(it.next()));
        return list;
    }

    @DeleteMapping(path = "/api/films/{id}")
    public ResponseEntity<?> deleteFilm(@PathVariable(name = "id") Integer id) {
        Optional<FilmEntity> filmEntity = filmService.getFilm(id);
        if(filmEntity.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        filmService.deleteById(id);
        return new ResponseEntity<>(filmEntity, HttpStatus.OK);
    }

    //@PutMapping(path = "api/films")
    /*public FilmDto put(@RequestBody FilmDto film) {
        FilmEntity filmEn = filmMapper.mapFrom(film);
        //filmService
    }*/

}
