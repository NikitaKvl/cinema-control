package cinema.application.controller;

import cinema.application.dto.response.UserResponseDto;
import cinema.application.service.UserService;
import cinema.application.service.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "Authorization")
public class UserController {
    private final UserService userService;

    @GetMapping("/by-email")
    @Operation(summary = "Find user by email")
    public UserResponseDto findByEmail(@RequestParam String email) {
        return UserMapper.INSTANCE.mapToDto(userService.findByEmail(email).orElseThrow(()
                -> new RuntimeException("Can't find user by email " + email)));
    }
}
