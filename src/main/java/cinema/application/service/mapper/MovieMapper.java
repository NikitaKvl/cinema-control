package cinema.application.service.mapper;

import cinema.application.dto.request.MovieRequestDto;
import cinema.application.dto.response.MovieResponseDto;
import cinema.application.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    Movie mapToModel(MovieRequestDto movieRequestDto);

    MovieResponseDto mapToDto(Movie movie);
}
