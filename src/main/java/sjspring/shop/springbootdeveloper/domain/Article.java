package sjspring.shop.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) //name이 title이라는 컬럼과 매핑된다.
    private String title;

    @Column(name = "content", nullable = false) //name이 content이라는 컬럼과 매핑된다.
    private String content;



    @Builder //빌더 패턴으로 필드값을 가져와 객체를 생성한다.
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    @CreatedDate //엔티티가 생성될 때의 시간을 create_at Column에 저장한다.
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}