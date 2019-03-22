package at.nacs.trickster;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class Trickster {

    private final RestTemplate restTemplate;
    private Random random = new Random();
    @Getter
    @Value("${server.url}")
    private List <String> url;

    String play() {
        delete();
        pickOne();
        return "The game has started!";
    }

    private void pickOne() {
        restTemplate.put(url.get(random.nextInt(2)), Void.class);
    }

    private void delete() {
        url.forEach(e -> restTemplate.delete(e, Void.class));
    }

    boolean choose(int number) {
        return restTemplate.getForObject(url.get(number), Boolean.class);
    }
}
