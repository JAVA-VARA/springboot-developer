package sjspring.shop.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public void test(){
        //생성
        memberRepository.save(new Member(1L, "A"));

        //조회
        Optional<Member> member = memberRepository.findById(1L);
        List<Member> allNumbers = memberRepository.findAll();

        //삭제
        memberRepository.deleteById(1L);
    }
}
