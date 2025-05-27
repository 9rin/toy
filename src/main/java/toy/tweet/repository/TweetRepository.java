package toy.tweet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.tweet.domain.Tweet;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    List<Tweet> findByOrderByCreatedAtDesc();
}
