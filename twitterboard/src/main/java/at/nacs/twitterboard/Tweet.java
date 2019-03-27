package at.nacs.twitterboard;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Tweet {

    private String id;
    private String user;
    private String message;
    private int likes;
    private List<String> comments;
    private LocalDateTime timestamp;
}
