package sjspring.shop.springbootdeveloper.controller;


import lombok.RequiredArgsConstructor;
import sjspring.shop.springbootdeveloper.domain.Article;
import sjspring.shop.springbootdeveloper.dto.AddArticleRequest;
import sjspring.shop.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

}