package sjspring.shop.springbootdeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// 스프링 데이터 JPA => JpaRepository를 IMPORT 한다.

import sjspring.shop.springbootdeveloper.domain.Article;

// repository 역할을 하는 인터페이스
//제네릭에 <관리할 엔티티의 이름, 엔티티 기본키의 타입>을 입력하면 CRUD를 위해 만든 메서드를 사용할 수 있다.

public interface BlogRepository extends JpaRepository<Article, Long> {

}
