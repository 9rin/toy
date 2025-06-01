package toy.user;

// User 조회 후 응답 Dto

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Builder
@Getter
public class UserResponseDto {

    // 표시할 것: 닉네임, 핸들, 이메일, 자기소개, 계정 생성일자
    private Long userId;
    private String nickname;
    private String handle;
    private String email;
    private String explanation;
    private LocalDateTime createdAt;


    // Build
    public static UserResponseDto from(User user){
        return UserResponseDto.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .handle(user.getHandle())
                .email(user.getEmail())
                .explanation(user.getExplanation())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
