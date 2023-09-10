package cinema.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CinemaHallRequestDto {
    @Min(value = 10, message = "Cinema hall capacity should be greater than 10")
    private int capacity;
    @Size(max = 200, message = "Maximum description length 200 characters")
    private String description;
}
