package cinema.application.service.mapper;

import cinema.application.dto.request.CinemaHallRequestDto;
import cinema.application.dto.response.CinemaHallResponseDto;
import cinema.application.model.CinemaHall;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CinemaHallMapper {
    CinemaHallMapper INSTANCE = Mappers.getMapper(CinemaHallMapper.class);

    CinemaHall mapToModel(CinemaHallRequestDto dto);

    CinemaHallResponseDto mapToDto(CinemaHall cinemaHall);
}
