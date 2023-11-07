package swapi.app.mappers.impl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import swapi.app.domain.dto.FilmDto;
import swapi.app.domain.entities.FilmEntity;
import swapi.app.mappers.Mapper;

@Component
public class FilmMapper implements Mapper<FilmEntity, FilmDto> {
    private ModelMapper modelMapper;

    public FilmMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public FilmDto mapTo(FilmEntity filmEntity) {
        return modelMapper.map(filmEntity, FilmDto.class);
    }

    @Override
    public FilmEntity mapFrom(FilmDto filmDto) {
        return modelMapper.map(filmDto, FilmEntity.class);
    }
}
