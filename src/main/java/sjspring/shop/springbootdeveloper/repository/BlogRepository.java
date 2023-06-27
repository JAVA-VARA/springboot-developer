package sjspring.shop.springbootdeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sjspring.shop.springbootdeveloper.domain.Article;

public interface BlogRepository extends JpaRepository<Article, Long> {

}
