package at.nacs.jacksparrow;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class JackSparrowClient {
    private final RestTemplate restTemplate;
    @Value("${tiadalma.url}")
    private String url;

    String get(){
        String urlDutchman = restTemplate.getForObject(url, String.class);
        DeadMansChest deadMansChest = restTemplate.getForObject(urlDutchman, DeadMansChest.class);
        return deadMansChest.getItem();
    }
}
