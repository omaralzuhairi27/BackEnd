package at.nacs.administration.client;

import at.nacs.administration.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AdmisstionClient {

  private final RestTemplate restTemplate;

  @Value("${admission.url}")
  private String url;

  public void post(Patient patient) {
    restTemplate.postForObject(url, patient, Patient.class);
  }
}
