package cinema.application.service.impl;

import cinema.application.dto.request.MovieSessionRequestDto;
import cinema.application.dto.response.MovieSessionResponseDto;
import cinema.application.model.Movie;
import cinema.application.model.MovieSession;
import cinema.application.repository.MovieSessionRepository;
import cinema.application.service.MovieService;
import cinema.application.service.MovieSessionService;
import cinema.application.service.mapper.MovieSessionAfterMappingContext;
import cinema.application.service.mapper.MovieSessionMapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieSessionServiceImpl implements MovieSessionService {
    private static MovieSessionMapper movieSessionMapper = MovieSessionMapper.INSTANCE;
    private final MovieService movieService;
    private final MovieSessionRepository movieSessionRepository;
    private final MovieSessionAfterMappingContext context;

    @Override
    public List<MovieSessionResponseDto> findAvailableSessions(Long movieId, LocalDate date) {
        Movie movie = movieService.get(movieId);
        LocalDateTime startOfDay = date.atTime(LocalTime.MIN);
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
        return movieSessionRepository
                .findMovieSessionByMovieAndShowTimeBetween(movie, startOfDay, endOfDay)
                .stream().map(movieSessionMapper::mapToDto).toList();
    }

    @Override
    public MovieSessionResponseDto create(MovieSessionRequestDto requestDto) {
        return movieSessionMapper.mapToDto(movieSessionRepository.save(
                movieSessionMapper.mapToModel(requestDto, context)));
    }

    @Override
    public MovieSession get(Long id) {
        return movieSessionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Session with id " + id + " not found"));
    }

    @Override
    public MovieSessionResponseDto update(Long id, MovieSessionRequestDto requestDto) {
        MovieSession movieSession = movieSessionMapper.mapToModel(requestDto, context);
        movieSession.setId(id);
        return movieSessionMapper.mapToDto(movieSessionRepository.save(movieSession));
    }

    @Override
    public void delete(Long id) {
        movieSessionRepository.deleteById(id);
    }
}
