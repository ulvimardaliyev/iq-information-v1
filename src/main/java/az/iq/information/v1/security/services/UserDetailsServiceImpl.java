package az.iq.information.v1.security.services;

import az.iq.information.v1.dao.entity.User;
import az.iq.information.v1.dao.repository.UserRepository;
import az.iq.information.v1.dto.response.UserResponseDto;
import az.iq.information.v1.mapstruct.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("HEY INSIDE LOADSUSER");
        User user = userRepository.findUserByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("Username not found"));
        UserResponseDto userResponse = userMapper.userEntityToResponse(user);
        return UserDetailsImpl.build(userResponse);
    }
}
