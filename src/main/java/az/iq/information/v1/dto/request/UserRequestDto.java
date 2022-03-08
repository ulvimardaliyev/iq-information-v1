package az.iq.information.v1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDto {
    @Valid
    @NotBlank
    @Size(min = 3, max = 20, message = "username should not be more than 20 or less than 3 symbols")
    private String username;
    @Valid
    @NotBlank
    @Size(min = 8, max = 120)
    private String password;
    @NotBlank
    @Valid
    @Email
    @Size(max = 50)
    private String email;
   /* @CreationTimestamp
    private LocalDateTime createdTime;*/
}
