package at.nacs.twitterboard;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
@RequiredArgsConstructor
public class TweetEndpoint {

    private final TweetManager tweetManager;

    @GetMapping
    List<Tweet> getAll() {
        return tweetManager.findAll();
    }

    @GetMapping("/user/{user}")
    List<Tweet> getUserTweets(@PathVariable String user) {
        return tweetManager.findallTweetOfUser(user);
    }

    @PostMapping
    Tweet saveNewTweet(@RequestBody Tweet tweet) {
        return tweetManager.postTweet(tweet);

    }

    @PutMapping("/{id}/likes")
    Tweet addOneLike(@PathVariable String id) {
        return tweetManager.updateTweetLikes(id);
    }

    @PutMapping("/{id}/comments")
    void addOneComment( @PathVariable String id, @RequestBody String comment) {
         tweetManager.addComment( id,comment);
    }
}
/*
/tweets/user/{user}
/tweets/{id}/likes
/tweets/{id}/comments
Behaviour:
GET to /tweets -> returns all Tweets ordered by timestamp descending.
GET to /tweets/user/{user} -> returns all Tweets of user ordered by timestamp descending
POST a Tweet to /tweets -> saves new Tweet. The app sets the timestamp of the Tweet right before saving it.
PUT to /tweets/{id}/likes -> adds one like to the Tweet with id.
PUT to /tweets/{id}/comments -> adds to the Tweet with id one comment received via request body.
*/