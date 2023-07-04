package sjspring.shop.springbootdeveloper.dto;

import lombok.Getter;
import sjspring.shop.springbootdeveloper.domain.Article;
@Getter
public class ArticleListViewResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponse(Article article){
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
