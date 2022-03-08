package az.iq.information.v1.controller;

import az.iq.information.v1.dto.request.LoginRequest;
import az.iq.information.v1.dto.request.UserRequestDto;
import az.iq.information.v1.dto.response.UserResponseDto;
import az.iq.information.v1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@Valid @RequestBody LoginRequest loginRequest,
                                                 HttpServletResponse response) {
        return ResponseEntity.ok(userService.login(loginRequest, response));
    }

    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(@Valid @RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userService.signUp(userRequestDto));
    }
}
