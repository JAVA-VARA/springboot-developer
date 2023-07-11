package sjspring.shop.springbootdeveloper.dto;

//토큰 생성 요청 및 응답을 담당하는 dto

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccessTokenRequest {
    private String refreshToken;

}
