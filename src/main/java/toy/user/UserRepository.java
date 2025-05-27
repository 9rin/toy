package toy.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 핸들 중복 검사
    boolean existsByHandle(String handle);

    // 이메일 중복 검사
    boolean existsByEmail(String email);

    // User Id로 조회
    Optional<User> findByUserId(Long userId);

}
