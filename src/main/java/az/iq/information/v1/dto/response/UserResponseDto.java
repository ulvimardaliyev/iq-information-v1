package az.iq.information.v1.dto.response;

import az.iq.information.v1.dao.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Set<Role> role;
}
