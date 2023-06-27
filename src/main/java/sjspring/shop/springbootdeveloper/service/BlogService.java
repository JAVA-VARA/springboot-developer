package sjspring.shop.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import sjspring.shop.springbootdeveloper.domain.Article;
import sjspring.shop.springbootdeveloper.dto.AddArticleRequest;
import sjspring.shop.springbootdeveloper.dto.UpdateArticleRequest;
import sjspring.shop.springbootdeveloper.repository.BlogRepository;

import java.util.List;


@RequiredArgsConstructor //final이 붙거나, @NotNull이 붙은 필드의 생성자를 추가한다.
@Service //빈으로 등록.
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그에 글 추가하는 메서드.
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
        //JapRepository에서 지원하는 저장 메서드 save()로 AddArticleRequest클래스에 저장된 값들을 db에 저장한다.
    }

    //JPA 지원 메서드인 findAll()을 호출해 article 테이블에 저장되어 있는 모든 테이블을 조회한다.
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found" + id));
    }

    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found:" + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}






