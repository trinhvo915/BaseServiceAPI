package trinh.vo.van.service.role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trinh.vo.van.model.entity.user.Role;
import trinh.vo.van.repository.RoleRepository;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role getRoleByName(String name) {
        Role role = roleRepository.findByName(name);
        if(Objects.nonNull(role)) {
            return role;
        }
        return null;
    }
}
