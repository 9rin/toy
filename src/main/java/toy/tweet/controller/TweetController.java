package toy.tweet.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toy.tweet.dto.request.TweetCreateRequestDto;
import toy.tweet.dto.response.TweetListResponse;
import toy.tweet.dto.response.TweetResponseDto;
import toy.tweet.service.TweetService;

@RestController
@RequestMapping("/tweets")
@RequiredArgsConstructor
public class TweetController {

    private final TweetService tweetService;

    // 트윗 생성
    @PostMapping
    public ResponseEntity<Void> createTweet(@RequestBody @Valid TweetCreateRequestDto dto){
        tweetService.createTweet(dto);
        return ResponseEntity.noContent().build();
    }

    // 트윗 삭제
    @DeleteMapping("/{tweetId}")
    public ResponseEntity<Void> deleteTweet(@PathVariable("tweetId") Long tweetId){
        tweetService.deleteTweet(tweetId);
        return ResponseEntity.noContent().build();
    }

    // 트윗 개별 조회
    @GetMapping("/{tweetId}")
    public ResponseEntity<TweetResponseDto> getTweet(@PathVariable("tweetId") Long tweetId){
        TweetResponseDto dto = tweetService.getTweet(tweetId);
        return ResponseEntity.ok(dto);
    }

    // 트윗 전체 조회
    @GetMapping
    public ResponseEntity<TweetListResponse> getAllTweets() {
        return ResponseEntity.ok(tweetService.getAllTweets());
    }


}
