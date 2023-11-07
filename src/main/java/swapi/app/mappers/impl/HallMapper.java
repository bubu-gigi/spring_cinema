package swapi.app.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import swapi.app.domain.dto.HallDto;
import swapi.app.domain.entities.HallEntity;
import swapi.app.mappers.Mapper;


@Component
public class HallMapper implements Mapper<HallEntity, HallDto> {
    private ModelMapper modelMapper;

    public HallMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public HallDto mapTo(HallEntity hallEntity) {
        return modelMapper.map(hallEntity, HallDto.class);
    }

    @Override
    public HallEntity mapFrom(HallDto hallDto) {
        return modelMapper.map(hallDto, HallEntity.class);
    }
}
