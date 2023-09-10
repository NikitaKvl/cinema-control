package cinema.application.service.mapper;

import cinema.application.dto.request.MovieSessionRequestDto;
import cinema.application.model.MovieSession;
import cinema.application.service.CinemaHallService;
import cinema.application.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieSessionAfterMappingContext {
    private final CinemaHallService cinemaHallService;
    private final MovieService movieService;

    @AfterMapping
    public void updateEntity(MovieSessionRequestDto dto, @MappingTarget MovieSession movieSession) {
        movieSession.setMovie(movieService.get(dto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(dto.getCinemaHallId()));
    }
}
