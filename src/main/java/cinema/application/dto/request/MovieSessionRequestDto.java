package cinema.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MovieSessionRequestDto {
    @Positive(message = "Movie Id should be valid")
    private Long movieId;
    @Positive(message = "Cinema Hall Id should be valid")
    private Long cinemaHallId;
    @NotNull(message = "Show Time should be valid")
    private LocalDateTime showTime;
}
