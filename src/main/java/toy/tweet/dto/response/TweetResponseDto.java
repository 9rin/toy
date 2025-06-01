package toy.tweet.dto.response;

import lombok.Builder;
import lombok.Getter;
import toy.tweet.domain.Tweet;
import toy.user.User;

import java.time.LocalDateTime;

@Getter
@Builder
public class TweetResponseDto {

    // 표시할 것: ID, 닉네임, 핸들, 트윗 내용, 트윗 생성일자
    private Long userId;
    private String nickname;
    private String handle;
    private String content;
    private LocalDateTime createdAt;

    // Build
    public static TweetResponseDto from(Tweet tweet){
        return TweetResponseDto.builder()
                .userId(tweet.getId())
                .nickname(tweet.getUser().getNickname())
                .handle(tweet.getUser().getHandle())
                .content(tweet.getContent())
                .createdAt(tweet.getCreatedAt())
                .build();
    }
}
