package toy.tweet.dto.summary;

import toy.tweet.domain.Tweet;
import toy.user.User;

import java.time.LocalDateTime;

public record TweetSummary(Long tweetId, Long userId, String nickname, String handle, String content, LocalDateTime createdAt) {
    public static TweetSummary from(Tweet tweet) {
        return new TweetSummary(
                tweet.getId(),
                tweet.getUser().getUserId(),
                tweet.getUser().getNickname(),
                tweet.getUser().getHandle(),
                tweet.getContent(),
                tweet.getCreatedAt()
        );
    }
}
