package sjspring.shop.springbootdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//매핑 작업에 필요한 인터페이스 생성.
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
