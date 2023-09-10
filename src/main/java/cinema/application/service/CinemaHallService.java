package cinema.application.service;

import cinema.application.dto.request.CinemaHallRequestDto;
import cinema.application.dto.response.CinemaHallResponseDto;
import cinema.application.model.CinemaHall;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface CinemaHallService {
    CinemaHallResponseDto create(CinemaHallRequestDto requestDto);

    CinemaHall get(Long id);

    List<CinemaHallResponseDto> getAll(Pageable pageable);
}
