package at.nacs.encoderintegrationtests.communication;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class EncoderClient {

    private final RestTemplate restTemplate;

    @Value("${encoder.url}")
    private String url;

    public String encode(String message) {
        return restTemplate.postForObject(url, message, String.class);
    }

}
