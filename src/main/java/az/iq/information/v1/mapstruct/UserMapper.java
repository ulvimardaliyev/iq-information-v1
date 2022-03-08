package az.iq.information.v1.mapstruct;

import az.iq.information.v1.dao.entity.User;
import az.iq.information.v1.dto.request.UserRequestDto;
import az.iq.information.v1.dto.response.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userRequestToEntity(UserRequestDto userRequestDto);

    UserResponseDto userEntityToResponse(User user);
}
