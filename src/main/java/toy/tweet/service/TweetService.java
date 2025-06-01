package toy.tweet.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;
import toy.global.exception.ExceptionCode;
import toy.global.exception.ToyException;
import toy.tweet.domain.Tweet;
import toy.tweet.dto.request.TweetCreateRequestDto;
import toy.tweet.dto.response.TweetListResponse;
import toy.tweet.dto.response.TweetResponseDto;
import toy.tweet.dto.summary.TweetSummary;
import toy.tweet.repository.TweetRepository;
import toy.user.User;
import toy.user.UserRepository;
import toy.user.UserResponseDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    // 트윗 생성
    @Transactional
    public TweetResponseDto createTweet(@Valid TweetCreateRequestDto dto) {
        // userId로 사용자 조회
        User user = userRepository.findByUserId(dto.getUserId())
                .orElseThrow(()-> new ToyException(ExceptionCode.USER_NOT_FOUND));
        // Tweet
        Tweet tweet = tweetRepository.save(dto.toEntity(user));
        return TweetResponseDto.from(tweet);
    }


    // 트윗 삭제
    @Transactional
    public void deleteTweet(Long tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(()->new ToyException((ExceptionCode.TWEET_NOT_FOUND)));
        tweetRepository.delete(tweet);
    }

    // 트윗 목록 조회
    @Transactional(readOnly = true)
    public TweetListResponse getAllTweets() {
        List<TweetSummary> summaries = tweetRepository.findByOrderByCreatedAtDesc()
                .stream().map(TweetSummary::from).toList();

        return new TweetListResponse(summaries, tweetRepository.count());
    }

    // 트윗 개별 조회
    @Transactional
    public TweetResponseDto getTweet(Long tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new IllegalArgumentException("해당 트윗을 찾을 수 없습니다."));
        return TweetResponseDto.from(tweet);
    }
}
