package at.nacs.drhouseaccountancy;

import at.nacs.drhouseaccountancy.logic.Accountant;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class AccountantEndpoint {

  private final Accountant accountant;


  @PostMapping
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

}
