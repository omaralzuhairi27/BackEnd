package at.nacs.morseencoderui.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiuration {

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
