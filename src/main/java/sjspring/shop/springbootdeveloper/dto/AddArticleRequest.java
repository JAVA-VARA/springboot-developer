package sjspring.shop.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sjspring.shop.springbootdeveloper.domain.Article;

@NoArgsConstructor  //기본 생성자 추가
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

    //생성자를 사용해 객체 생성.
    //toEntity는 빌더 패턴을 사용해 dto를 entity로 만들어주는 메서드이다.
    public Article toEntity(){
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
