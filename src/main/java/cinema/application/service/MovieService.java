package cinema.application.service;

import cinema.application.dto.request.MovieRequestDto;
import cinema.application.dto.response.MovieResponseDto;
import cinema.application.model.Movie;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface MovieService {
    MovieResponseDto create(MovieRequestDto requestDto);

    Movie get(Long id);

    List<MovieResponseDto> getAll(Pageable pageable);
}
