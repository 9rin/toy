package toy.tweet.dto.summary;

import toy.tweet.domain.Tweet;
import toy.user.User;

public record TweetSummary(Long tweetId, String nickname, String handle, String content) {
    public static TweetSummary from(Tweet tweet) {
        return new TweetSummary(
                tweet.getId(),
                tweet.getUser().getNickname(),
                tweet.getUser().getHandle(),
                tweet.getContent()
        );
    }
}
