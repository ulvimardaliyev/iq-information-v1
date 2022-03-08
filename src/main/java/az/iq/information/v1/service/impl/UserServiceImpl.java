package az.iq.information.v1.service.impl;

import az.iq.information.v1.dao.entity.ERole;
import az.iq.information.v1.dao.entity.Role;
import az.iq.information.v1.dao.entity.User;
import az.iq.information.v1.dao.repository.RoleRepository;
import az.iq.information.v1.dao.repository.UserRepository;
import az.iq.information.v1.dto.request.LoginRequest;
import az.iq.information.v1.dto.request.UserRequestDto;
import az.iq.information.v1.dto.response.UserResponseDto;
import az.iq.information.v1.exception.UserExistException;
import az.iq.information.v1.exception.UserNotFoundException;
import az.iq.information.v1.mapstruct.UserMapper;
import az.iq.information.v1.security.jwt.JwtUtils;
import az.iq.information.v1.security.services.UserDetailsImpl;
import az.iq.information.v1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @Override
    public UserResponseDto login(LoginRequest loginRequest, HttpServletResponse servletResponse) {

        Optional<User> currentUser = userRepository.findUserByEmail(loginRequest.getEmail());
        if (currentUser.isPresent()
                && userPasswordCheck(loginRequest.getPassword(), currentUser.get().getPassword())) {
            System.out.println("Inside login if");
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(currentUser.get().getUsername(),
                            loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = "Bearer " + jwtUtils.generateJwtToken(authentication);
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            servletResponse.setHeader("Authorization", jwt);
            return userMapper.userEntityToResponse(currentUser.get());
        }
        System.out.println("Inside else in login()");
        throw new UserNotFoundException("User not found ");
    }

    @Transactional
    @Override
    public UserResponseDto signUp(UserRequestDto userRequestDto) {
        if (userRepository.existsByUsernameOrEmail(userRequestDto.getUsername(),
                userRequestDto.getEmail())) {
            throw new UserExistException("Username or email already exists");
        }
        userRequestDto.setPassword(encoder.encode(userRequestDto.getPassword()));
        User user = userMapper.userRequestToEntity(userRequestDto);
        Role role = roleRepository.findRoleById(ERole.ROLE_USER.getRolePosition());
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRole(roles);
        return userMapper.userEntityToResponse(userRepository.save(user));
    }

    @Override
    public UserResponseDto profile() {
        return null;
    }

    private boolean userPasswordCheck(String requestPassword, String savedPassword) {
        return encoder.matches(requestPassword, savedPassword);
    }
}
