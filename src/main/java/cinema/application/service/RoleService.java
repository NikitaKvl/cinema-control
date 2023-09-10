package cinema.application.service;

import cinema.application.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);
}
