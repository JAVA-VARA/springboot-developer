import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import sjspring.shop.springbootdeveloper.Member;

import javax.swing.text.html.parser.Entity;

public class EntityManagerTest {

    @Autowired
    EntityManager em;

    public void example(){
        // 1. 비영속 상태
        Member member = new Member(1L, "퐁길동");

        // 2. 관리 상태
        em.persist(member);

        //3. 분리 상태
        em.detach(member);

        //4. 삭제
        em.remove(member);
    }
}
