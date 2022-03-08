package az.iq.information.v1.dao.entity;

import lombok.Getter;

@Getter
public enum ERole {
    ROLE_USER(1),
    ROLE_MODERATOR(2),
    ROLE_ADMIN(3);

    private long rolePosition;

    ERole(long rolePosition) {
        this.rolePosition = rolePosition;
    }
}
