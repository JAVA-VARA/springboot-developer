package sjspring.shop.springbootdeveloper.config.jwt;

//토큰생성
//유효성 검사
//토큰에서 필요한 정보를 가져오는 클래스

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import sjspring.shop.springbootdeveloper.domain.User;

import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
@RequiredArgsConstructor
@Service
public class TokenProvider {

    private final JwtProperties jwtProperties;

    public String generateToken(User user, Duration expiredAt) {
        Date now = new Date();
        return makeToken(new Date(now.getTime() + expiredAt.toMillis()), user);
    }
    //JWT 토큰 생성 메서드
    //인자로 만료시간과 유저 정보를 받는다.
    //set 계열의 메서드를 통해 토큰에 값을 지정한다.
    private String makeToken(Date expiry, User user) {
        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .setSubject(user.getEmail())
                .claim("id", user.getId())
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey()) //hs256 방식으로 암호화
                .compact();
    }

    // 토큰이 유효한지 검증하는 메서드
    public boolean validToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey()) // jwtProperties 클래스 파일에서 SecretKey를 가져와서 토큰 유효성 판단
                    .parseClaimsJws(token);

            return true;
        } catch (Exception e) { //복호화과정에서 에러가 발생하면 false 반환.
            return false;
        }
    }

    //토큰을 받아 인증 정보를 담은 객체 Authentication을 반환하는 메서드
    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        Set<SimpleGrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

        return new UsernamePasswordAuthenticationToken
                (new org.springframework.security.core.userdetails.User
                        (claims.getSubject(), "", authorities), token, authorities);
    }

    //토큰 기반으로 사용자 id를 가져오는 메서드
    public Long getUserId(String token) {
        Claims claims = getClaims(token);
        return claims.get("id", Long.class);
    }

    //jwtProperties에 저장한 secret key를 토큰으로 복호화한 뒤 클레임을 가져오는 private 메서드
    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody();
    }
}
