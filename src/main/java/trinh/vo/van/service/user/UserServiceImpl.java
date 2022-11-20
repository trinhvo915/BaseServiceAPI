package trinh.vo.van.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trinh.vo.van.constant.EmailConstants;
import trinh.vo.van.model.dto.response.user.UserResponses;
import trinh.vo.van.model.entity.user.User;
import trinh.vo.van.model.filter.UserFilter;
import trinh.vo.van.repository.UserRepository;
import trinh.vo.van.service.email.IEmailService;
import trinh.vo.van.utils.ThreadUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final IEmailService emailService;

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
        ThreadUtil.runAsync(() -> sendEmailSignUpUser(user));

        return userRepository.save(user);
    }

    private void sendEmailSignUpUser(User user){
        String subject = "Sign Up User";
        Map<String, Object> emailContent = new HashMap<>();

        emailContent.put(EmailConstants.EMAIL, user.getEmail());
        emailContent.put(EmailConstants.FULLNAME, user.getFullName());

        emailService.sendEmail(new String[]{user.getEmail()}
                , new String[0]
                , subject
                , EmailConstants.SIGN_UP_USER_TEMPLATE_MAIL
                , emailContent);
    }

    @Override
    public List<UserResponses> getUsers(UserFilter userFilter) {

        return null;
    }
}
