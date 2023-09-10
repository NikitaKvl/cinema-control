package cinema.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MovieRequestDto {
    @NotNull(message = "Title must be present")
    private String title;
    @Size(max = 200, message = "Maximum description length 200 characters")
    private String description;
}
