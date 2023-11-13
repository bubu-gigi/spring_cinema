package swapi.app.mappers.impl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import swapi.app.domain.dto.HallDto;
import swapi.app.domain.dto.TicketDto;
import swapi.app.domain.entities.HallEntity;
import swapi.app.domain.entities.TicketEntity;
import swapi.app.mappers.Mapper;

@Component
public class TicketMapper implements Mapper<TicketEntity, TicketDto> {
    private ModelMapper modelMapper;

    public TicketMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public TicketDto mapTo(TicketEntity ticketEntity) {
        return modelMapper.map(ticketEntity, TicketDto.class);
    }

    @Override
    public TicketEntity mapFrom(TicketDto ticketDto) {
        return modelMapper.map(ticketDto, TicketEntity.class);
    }
}
