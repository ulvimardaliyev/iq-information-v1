package az.iq.information.v1;

import az.iq.information.v1.dao.repository.RoleRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "IQ Information", version = "0.0.1", description = "IQ Info"))
public class IqInformationV1Application /*implements CommandLineRunner*/ {
    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(IqInformationV1Application.class, args);
    }
   /* @Override
    public void run(String... args) throws Exception {
        Role role_user = new Role();
        role_user.setRoleName("ROLE_USER");
        Role role_admin = new Role();
        role_admin.setRoleName("ROLE_ADMIN");
        Role role_man = new Role();
        role_man.setRoleName("ROLE_MODERATOR");

        roleRepository.save(role_user);
        roleRepository.save(role_man);
        roleRepository.save(role_admin);
    }*/
}
