package at.nacs.twitterboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TweetManager {

    private final TweetRepository repository;

    public List<Tweet> findAll() {
        return repository.findAllByOrderByTimestampDesc();
    }

    public List<Tweet> findallTweetOfUser(String user) {
       return repository.findAllByUserOrderByTimestampDesc(user);
//        return tweets.stream()
//                .sorted(Comparator.comparing(Tweet ::getTimestamp).reversed())
//                .collect(Collectors.toList());
    }

    public Tweet postTweet(Tweet tweet) {
        LocalDateTime localDateTime = LocalDateTime.now();
        tweet.setTimestamp(localDateTime);
        return repository.save(tweet);
    }

    public Tweet updateTweetLikes(String id) {
        Tweet tweet = repository.findById(id).orElse(null);
        int likes = tweet.getLikes();
        tweet.setLikes(likes + 1);
        repository.save(tweet);
        return tweet;
    }

    public void addComment(String id,  String comment){
        Tweet tweet = repository.findById(id).orElse(null);
        List<String> comments = tweet.getComments();
        comments.add(comment);
        tweet.setComments(comments);
        repository.save(tweet);

    }


}
/*
PUT to /tweets/{id}/comments -> adds to the Tweet with id one comment received via request body.
*/