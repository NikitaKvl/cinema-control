package cinema.application.service.impl;

import cinema.application.dto.request.MovieRequestDto;
import cinema.application.dto.response.MovieResponseDto;
import cinema.application.model.Movie;
import cinema.application.repository.MovieRepository;
import cinema.application.service.MovieService;
import cinema.application.service.mapper.MovieMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private static MovieMapper movieMapper = MovieMapper.INSTANCE;
    private final MovieRepository movieRepository;

    @Override
    public MovieResponseDto create(MovieRequestDto requestDto) {
        return movieMapper.mapToDto(movieRepository.save(movieMapper.mapToModel(requestDto)));
    }

    @Override
    public Movie get(Long id) {
        return movieRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find movie by id " + id));
    }

    @Override
    public List<MovieResponseDto> getAll(Pageable pageable) {
        return movieRepository.findAll(pageable).getContent()
                .stream()
                .map(movieMapper::mapToDto)
                .toList();
    }
}
