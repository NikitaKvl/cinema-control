package cinema.application.controller;

import cinema.application.dto.UserLoginDto;
import cinema.application.dto.request.UserRequestDto;
import cinema.application.dto.response.UserResponseDto;
import cinema.application.model.User;
import cinema.application.security.JwtTokenProvider;
import cinema.application.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    @Operation(summary = "Register user")
    public UserResponseDto register(@Valid @RequestBody UserRequestDto requestDto) {
        return authService.register(requestDto);
    }

    @PostMapping("/login")
    @Operation(summary = "Login user")
    public ResponseEntity<Object> login(@RequestBody UserLoginDto userLoginDto)
            throws AuthenticationException {
        User user = authService.login(userLoginDto.getEmail(), userLoginDto.getPassword());
        return jwtTokenProvider.loginUser(user);
    }
}
