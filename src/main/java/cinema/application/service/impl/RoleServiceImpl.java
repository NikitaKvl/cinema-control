package cinema.application.service.impl;

import cinema.application.model.Role;
import cinema.application.repository.RoleRepository;
import cinema.application.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String roleName) {
        return roleRepository.getRoleByRoleName(Role.RoleName.valueOf(roleName)).orElseThrow();
    }
}
