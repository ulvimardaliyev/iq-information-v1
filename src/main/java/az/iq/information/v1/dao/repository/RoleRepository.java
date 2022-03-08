package az.iq.information.v1.dao.repository;

import az.iq.information.v1.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleById(Long id);
}
