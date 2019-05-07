package at.nacs.administration.client;

import at.nacs.administration.domain.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceClient {
  private final RestTemplate restTemplate;
  @Value("${accountancy.url}")
  private String url;

  public List<Invoice> getAllInvoive() {
    Invoice[] invoicesArray = restTemplate.getForObject(url, Invoice[].class);
    return Arrays.asList(invoicesArray);
  }

  public void setPaid(String id) {
    restTemplate.put(url + "/" + id + "/paid", void.class);
  }

  public void deleteInvoive(Long id) {
    restTemplate.delete(url + "/" + id);
  }


}
