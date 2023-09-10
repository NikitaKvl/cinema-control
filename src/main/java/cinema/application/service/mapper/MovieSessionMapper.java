package cinema.application.service.mapper;

import cinema.application.dto.request.MovieSessionRequestDto;
import cinema.application.dto.response.MovieSessionResponseDto;
import cinema.application.model.MovieSession;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieSessionMapper {
    MovieSessionMapper INSTANCE = Mappers.getMapper(MovieSessionMapper.class);

    MovieSession mapToModel(MovieSessionRequestDto dto,
                            @Context MovieSessionAfterMappingContext context);

    @Mapping(source = "movie.title", target = "movieTitle")
    @Mapping(source = "movie.id", target = "movieId")
    @Mapping(source = "cinemaHall.id", target = "cinemaHallId")
    @Mapping(source = "id", target = "movieSessionId")
    MovieSessionResponseDto mapToDto(MovieSession movieSession);

}
