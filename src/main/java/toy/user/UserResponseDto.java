package toy.user;

// User 조회 후 응답 Dto

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponseDto {

    // 표시할 것: 닉네임, 핸들, 이메일, 자기소개, 계정 생성일자
    private String nickname;
    private String handle;
    private String email;
    private String explanation;

    // Build
    public static UserResponseDto from(User user){
        return UserResponseDto.builder()
                .nickname(user.getNickname())
                .handle(user.getHandle())
                .email(user.getEmail())
                .explanation(user.getExplanation())
                .build();
    }
}
