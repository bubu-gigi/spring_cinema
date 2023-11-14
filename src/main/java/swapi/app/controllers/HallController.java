package swapi.app.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swapi.app.domain.dto.HallDto;
import swapi.app.domain.entities.HallEntity;
import swapi.app.mappers.Mapper;
import swapi.app.services.HallService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class HallController {
    private final HallService hallService;
    private final Mapper<HallEntity, HallDto> hallMapper;

    public HallController(HallService hallService, Mapper<HallEntity, HallDto> hallMapper) {
        this.hallService = hallService;
        this.hallMapper = hallMapper;
    }

    @GetMapping(path = "/api/halls")
    public List<HallDto> show() {
        Iterable<HallEntity> halls = hallService.getHalls();
        Iterator<HallEntity> it = halls.iterator();
        List<HallDto> list = new ArrayList<>();
        while(it.hasNext())
            list.add(hallMapper.mapTo(it.next()));
        return list;
    }

    @PostMapping(path = "/api/halls")
    public ResponseEntity<HallDto> postHall(@RequestBody HallDto hall) {
        HallEntity hallEntity = hallMapper.mapFrom(hall);
        hallService.createHall(hallEntity);
        return new ResponseEntity<>(hallMapper.mapTo(hallEntity), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/api/halls/{id}")
    public ResponseEntity<?> deleteHall(@PathVariable(name = "id") Integer id) {
        Optional<HallEntity> hall = hallService.getHall(id);
        if(hall.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        hallService.deleteById(id);
        return new ResponseEntity<>(hall, HttpStatus.OK);
    }

    @GetMapping(path = "/api/halls/{id}")
    public ResponseEntity<HallDto> getHall(@PathVariable("id") Integer id) {
        Optional<HallEntity> hallEntity = hallService.getHall(id);
        if(hallEntity.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(hallMapper.mapTo(hallEntity.get()), HttpStatus.OK);
    }
}
