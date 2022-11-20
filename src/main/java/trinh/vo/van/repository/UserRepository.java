package trinh.vo.van.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import trinh.vo.van.model.entity.user.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findByUsernameLikeAndEmailLike(String username, String email);


    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
