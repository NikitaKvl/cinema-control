package cinema.application.controller;

import cinema.application.dto.request.CinemaHallRequestDto;
import cinema.application.dto.response.CinemaHallResponseDto;
import cinema.application.service.CinemaHallService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema-halls")
@RequiredArgsConstructor
@SecurityRequirement(name = "Authorization")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;

    @PostMapping
    @Operation(summary = "Create cinema hall")
    public CinemaHallResponseDto create(@RequestBody @Valid CinemaHallRequestDto requestDto) {
        return cinemaHallService.create(requestDto);
    }

    @GetMapping
    @Operation(summary = "Get all cinema hall")
    public List<CinemaHallResponseDto> getAll(@PageableDefault Pageable pageable) {
        return cinemaHallService.getAll(pageable);
    }
}
