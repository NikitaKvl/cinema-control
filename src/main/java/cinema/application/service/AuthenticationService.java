package cinema.application.service;

import cinema.application.dto.request.UserRequestDto;
import cinema.application.dto.response.UserResponseDto;
import cinema.application.model.User;
import org.apache.tomcat.websocket.AuthenticationException;

public interface AuthenticationService {
    UserResponseDto register(UserRequestDto requestDto);

    User login(String login, String password) throws AuthenticationException;
}
