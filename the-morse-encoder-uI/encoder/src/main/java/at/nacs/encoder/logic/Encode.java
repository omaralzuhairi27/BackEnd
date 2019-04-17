package at.nacs.encoder.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class Encode {

  private final RestTemplate restTemplate;

  @Value("${morse.url}")
  private String url;

  public String post(String message) {
    return Stream.of(message.split(""))
                 .filter(e -> !e.equals(" "))
                 .map(e -> getString(e))
                 .collect(Collectors.joining(""));
  }

  private String getString(String e) {
    return restTemplate.postForObject(url, e, String.class);
  }
}
