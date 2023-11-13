package swapi.app.mappers.impl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import swapi.app.domain.dto.BookingDto;
import swapi.app.domain.entities.BookingEntity;
import swapi.app.mappers.Mapper;

@Component
public class BookingMapper implements Mapper<BookingEntity, BookingDto> {
    private ModelMapper modelMapper;

    public BookingMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookingDto  mapTo(BookingEntity bookingEntity) {
        return modelMapper.map(bookingEntity, BookingDto.class);
    }

    @Override
    public BookingEntity  mapFrom(BookingDto bookingDto) {
        return modelMapper.map(bookingDto, BookingEntity.class);
    }
}
