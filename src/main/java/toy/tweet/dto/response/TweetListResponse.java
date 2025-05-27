package toy.tweet.dto.response;

import toy.tweet.dto.summary.TweetSummary;

import java.util.List;

public record TweetListResponse(List<TweetSummary> tweets, Long totalTweets) {}

