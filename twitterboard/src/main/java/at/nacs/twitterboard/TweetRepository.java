package at.nacs.twitterboard;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TweetRepository extends MongoRepository<Tweet, String> {
    // List<Tweet> findAllByOrderedByTimestampDesc();
    List<Tweet> findAllByUserOrderByTimestampDesc(String user);
    // List<Tweet> findAllByUser(String user);


    List<Tweet> findAllByOrderByTimestampDesc();
}
