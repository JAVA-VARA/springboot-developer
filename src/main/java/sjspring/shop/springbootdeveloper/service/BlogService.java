package sjspring.shop.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import sjspring.shop.springbootdeveloper.domain.Article;
import sjspring.shop.springbootdeveloper.dto.AddArticleRequest;
import sjspring.shop.springbootdeveloper.repository.BlogRepository;


@RequiredArgsConstructor //final이 붙거나, @NotNull이 붙은 필드의 생성자를 추가한다.
@Service //빈으로 등록.
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그에 글 추가하는 메서드.
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
        //JapRepository에서 지원하는 저장 메서드 save()로 AddArticlRequest클래스에 저장된 값들을 db에 저장한다.
    }

}






