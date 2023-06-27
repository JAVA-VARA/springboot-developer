package sjspring.shop.springbootdeveloper;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// DB에 접근할 때 사용할 객체인 MEMEBER DAO를 생성,
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자
@AllArgsConstructor
@Getter
@Entity  //엔티티로 지정

//실제 DB에 접근하는 코드 작성.

public class Member {
    @Id  //ID를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private  Long id; //DB 테이블의 id 컬럼과 매칭

    @Column(name = "name", nullable = false) //NAME이라는 NOTNULL 컬럼과 맵핑.
    private  String name; //DB 테이블의 name 컬럼과 매칭

}



