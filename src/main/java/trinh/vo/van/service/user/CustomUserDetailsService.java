package trinh.vo.van.service.user;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import trinh.vo.van.exception.NotFoundException;
import trinh.vo.van.model.entity.user.User;
import trinh.vo.van.repository.UserRepository;
import trinh.vo.van.security.UserPrincipal;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private static final String USER_NOT_FOUND_USERNAME_EMAIL = "User not found with username or email : ";
    private static final String USER_NOT_FOUND_ID = "User not found with Id : ";

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND_USERNAME_EMAIL + usernameOrEmail));
        return UserPrincipal.create(user);
    }

    public UserDetails loadUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND_ID + id));
        return UserPrincipal.create(user);
    }
}
