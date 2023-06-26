package sjspring.shop.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired //TestService 빈 주입.
    TestService testService;

    @GetMapping("/test") // test요청이 오면 test()메서드를 실행한다.
    public List<Member> getAllMembers(){
        List<Member> members = testService.getAllMembers();
        return members;
    }
}
