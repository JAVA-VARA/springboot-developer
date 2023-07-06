package sjspring.shop.springbootdeveloper.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sjspring.shop.springbootdeveloper.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}


