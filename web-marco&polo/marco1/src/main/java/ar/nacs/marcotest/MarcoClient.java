package ar.nacs.marcotest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class MarcoClient {

    private final RestTemplate restTemplate;

    @Value("${marco.server.url}")
    private String url;

    String get(String message){
        return restTemplate.postForObject(url,message,String.class);
    }


}
