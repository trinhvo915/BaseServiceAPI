package trinh.vo.van.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trinh.vo.van.model.dto.response.user.UserResponses;
import trinh.vo.van.model.entity.user.User;
import trinh.vo.van.model.filter.UserFilter;
import trinh.vo.van.repository.UserRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public Boolean existsByUsername(String username) {
        try {
            Boolean user = userRepository.existsByUsername(username);
            return Objects.nonNull(user) ? user : false;
        }catch (Exception exception){
            return false;
        }

    }

    @Override
    public Boolean existsByEmail(String email) {
        try {
            Boolean user = userRepository.existsByEmail(email);
            return Objects.nonNull(user) ? user : false;
        }catch (Exception exception){
            return false;
        }
    }


    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserResponses> getUsers(UserFilter userFilter) {

        return null;
    }
}
