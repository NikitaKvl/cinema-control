package cinema.application.service;

import cinema.application.dto.request.MovieSessionRequestDto;
import cinema.application.dto.response.MovieSessionResponseDto;
import cinema.application.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionService {
    List<MovieSessionResponseDto> findAvailableSessions(Long movieId, LocalDate date);

    MovieSessionResponseDto create(MovieSessionRequestDto session);

    MovieSession get(Long id);

    MovieSessionResponseDto update(Long id, MovieSessionRequestDto requestDto);

    void delete(Long id);
}
