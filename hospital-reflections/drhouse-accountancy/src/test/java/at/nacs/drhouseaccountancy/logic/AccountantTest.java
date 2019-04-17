package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ConfigurationProperties("data")
class AccountantTest {

  @SpyBean
  Accountant accountant;

  @MockBean
  InvoiceManager invoiceManager;


  @MockBean
  PatientManager patientManager;

  @Setter
  PatientDTO patient1;

  @Test
  void store() {
    Invoice invoice = accountant.store(patient1);
    Mockito.verify(accountant).store(patient1);
  }

  @Test
  void setPaid() {
    Invoice invoice = accountant.store(patient1);
    long invoiceId = 1l;
    Invoice invoice1 = accountant.setPaid(invoiceId);
    Mockito.verify(accountant).setPaid(invoiceId);

  }

  @Test
  void getAll() {
    List<Invoice> invoice1 = accountant.getAll();
    Mockito.verify(accountant, Mockito.times(1)).getAll();
  }
}