package cinema.application.dto.request;

import cinema.application.lib.FieldsValueMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!"
)
@Data
public class UserRequestDto {
    @Email(regexp = "^(.+)@(.+)$", message = "Please, enter a valid email")
    private String email;
    @Size(min = 8, max = 40, message = "Password length must be between 8 and 40 characters")
    private String password;
    @NotNull(message = "Please repeat password")
    private String repeatPassword;
}
