package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.PatientDTO;
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
    Mockito.verify(accountant, Mockito.times(1)).store(patient1);
  }

  @Test
  void setPaid() {
    Invoice invoice = accountant.store(patient1);
    Invoice invoice1 = accountant.setPaid(1l);
    Mockito.verify(accountant, Mockito.times(1)).setPaid(1l);

  }

  @Test
  void getAll() {
    List<Invoice> invoice1 = accountant.getAll();
    Mockito.verify(accountant, Mockito.times(1)).getAll();
  }
}