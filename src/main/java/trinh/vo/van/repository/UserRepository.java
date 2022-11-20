package trinh.vo.van.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trinh.vo.van.model.entity.user.User;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserNameOrEmail(String username, String email);

    boolean existsByUserName(String username);

    boolean existsByEmail(String email);

}
