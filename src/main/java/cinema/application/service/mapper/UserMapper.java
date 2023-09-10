package cinema.application.service.mapper;

import cinema.application.dto.response.UserResponseDto;
import cinema.application.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDto mapToDto(User user);
}
