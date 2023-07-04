package sjspring.shop.springbootdeveloper.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
