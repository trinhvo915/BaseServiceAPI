package trinh.vo.van.service.user;

import trinh.vo.van.model.dto.response.user.UserResponses;
import trinh.vo.van.model.entity.user.User;
import trinh.vo.van.model.filter.UserFilter;

import java.util.List;

public interface UserService {

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    User save(User user);

    List<UserResponses> getUsers(UserFilter userFilter);
}
