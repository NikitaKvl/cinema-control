package cinema.application.controller;

import cinema.application.dto.request.MovieSessionRequestDto;
import cinema.application.dto.response.MovieSessionResponseDto;
import cinema.application.service.MovieSessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
@RequiredArgsConstructor
@SecurityRequirement(name = "Authorization")
public class MovieSessionController {
    public static final String DATE_PATTERN = "dd.MM.yyyy";
    private final MovieSessionService movieSessionService;

    @PostMapping
    @Operation(summary = "Create movie session")
    public MovieSessionResponseDto create(@RequestBody @Valid MovieSessionRequestDto requestDto) {
        return movieSessionService.create(requestDto);
    }

    @GetMapping("/available")
    @Operation(summary = "Find available session")
    public List<MovieSessionResponseDto> findAvailableSessions(@RequestParam Long movieId,
                                                               @RequestParam
                                                               @DateTimeFormat
                                                                       (pattern = DATE_PATTERN)
                                                               LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update movie session by id")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody @Valid MovieSessionRequestDto requestDto) {
        return movieSessionService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleted movie session by id")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
