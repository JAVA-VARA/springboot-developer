package sjspring.shop.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sjspring.shop.springbootdeveloper.domain.RefreshToken;
import sjspring.shop.springbootdeveloper.repository.RefreshTokenRepository;

//전달받은 refresh token으로 refresh 토큰 객체를 검색해서 전달하는 메서드


@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken){
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()-> new IllegalArgumentException("Unexpected token"));
    }
}
