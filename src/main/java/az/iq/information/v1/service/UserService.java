package az.iq.information.v1.service;

import az.iq.information.v1.dto.request.LoginRequest;
import az.iq.information.v1.dto.request.UserRequestDto;
import az.iq.information.v1.dto.response.UserResponseDto;

import javax.servlet.http.HttpServletResponse;

public interface UserService {

    UserResponseDto login(LoginRequest loginRequest, HttpServletResponse httpServletResponse);

    UserResponseDto signUp(UserRequestDto userRequestDto);

    UserResponseDto profile();
}
