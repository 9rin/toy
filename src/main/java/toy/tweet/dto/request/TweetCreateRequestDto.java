package toy.tweet.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import toy.tweet.domain.Tweet;
import toy.user.User;

@Getter
@Setter
public class TweetCreateRequestDto {
    @NotNull
    private Long userId;

    @NotNull
    private String content;

    public Tweet toEntity(User user){
        return Tweet.builder()
                .user(user)
                .content(content)
                .build();
    }
}
