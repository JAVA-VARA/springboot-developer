package sjspring.shop.springbootdeveloper.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import sjspring.shop.springbootdeveloper.domain.Article;
import sjspring.shop.springbootdeveloper.dto.ArticleListViewResponse;
import sjspring.shop.springbootdeveloper.dto.ArticleViewResponse;
import sjspring.shop.springbootdeveloper.repository.BlogRepository;
import sjspring.shop.springbootdeveloper.service.BlogService;

import java.util.List;

@RequiredArgsConstructor
@Controller

public class BlogVewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles);

        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }

    @GetMapping("/new-article")
    // 쿼리파라미터로 넘어온 id값을 newArticle() Long 타입 id 인자에 매핑한다.(id는 없을 수도 있음)
    public String newArticle(@RequestParam(required = false) Long id, Model model)
    {
        if(id ==null){ //id가 없으면 새로 생성한다.
            model.addAttribute("article", new ArticleViewResponse());
        }else{ //id가 있으면 수정
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }
        return "newArticle";
    }

}
