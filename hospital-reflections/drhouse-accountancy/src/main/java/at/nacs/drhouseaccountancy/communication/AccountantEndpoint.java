package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.logic.Accountant;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class AccountantEndpoint {

  private final Accountant accountant;

  @PostMapping("/patients")
  void store(@RequestBody PatientDTO patientDTO) {
    accountant.store(patientDTO);
  }

  @GetMapping("/invoices")
  List<Invoice> getAll() {
    return accountant.getAll();
  }

  @PutMapping("/invoices/{id}/paid")
  void setAsPaid(@PathVariable long id) {
    Invoice invoice = accountant.setPaid(id);
  }

  @DeleteMapping("/invoices/{id}")
  void deleteInvoice(@PathVariable long id) {
    accountant.delete(id);
  }

}
