package cinema.application.service.impl;

import cinema.application.dto.request.CinemaHallRequestDto;
import cinema.application.dto.response.CinemaHallResponseDto;
import cinema.application.model.CinemaHall;
import cinema.application.repository.CinemaHallRepository;
import cinema.application.service.CinemaHallService;
import cinema.application.service.mapper.CinemaHallMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CinemaHallServiceImpl implements CinemaHallService {
    private static CinemaHallMapper cinemaHallMapper = CinemaHallMapper.INSTANCE;
    private final CinemaHallRepository cinemaHallRepository;

    @Override
    public CinemaHallResponseDto create(CinemaHallRequestDto requestDto) {
        return cinemaHallMapper.mapToDto(cinemaHallRepository
                .save(cinemaHallMapper.mapToModel(requestDto)));
    }

    @Override
    public CinemaHall get(Long id) {
        return cinemaHallRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find cinema hall by id " + id));
    }

    @Override
    public List<CinemaHallResponseDto> getAll(Pageable pageable) {
        return cinemaHallRepository.findAll(pageable).getContent()
                .stream()
                .map(cinemaHallMapper::mapToDto)
                .toList();
    }
}
