package sjspring.shop.springbootdeveloper;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// DB에 접근할 때 사용할 객체인 MEMEBER DAO를 생성,
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity

//실제 DB에 접근하는 코드 작성.

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private  Long id; //DB 테이블의 id 컬럼과 매칭

    @Column(name = "name", nullable = false)
    private  String name; //DB 테이블의 name 컬럼과 매칭

}
