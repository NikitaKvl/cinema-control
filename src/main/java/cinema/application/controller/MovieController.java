package cinema.application.controller;

import cinema.application.dto.request.MovieRequestDto;
import cinema.application.dto.response.MovieResponseDto;
import cinema.application.service.MovieService;
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
@RequestMapping("/movies")
@RequiredArgsConstructor
@SecurityRequirement(name = "Authorization")
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    @Operation(summary = "Create movie")
    public MovieResponseDto create(@RequestBody @Valid MovieRequestDto requestDto) {
        return movieService.create(requestDto);
    }

    @GetMapping
    @Operation(summary = "Get all movie")
    public List<MovieResponseDto> getAll(@PageableDefault Pageable pageable) {
        return movieService.getAll(pageable);
    }
}
