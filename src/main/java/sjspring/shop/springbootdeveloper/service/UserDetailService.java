package sjspring.shop.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import sjspring.shop.springbootdeveloper.domain.User;
import sjspring.shop.springbootdeveloper.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

// 스프링 시큐리티에서 로그인을 할때 사용자 정보를 가져오는 코드

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException((email)));
    }
}
