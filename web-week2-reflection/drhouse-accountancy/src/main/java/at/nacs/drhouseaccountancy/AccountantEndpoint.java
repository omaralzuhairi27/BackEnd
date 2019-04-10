package at.nacs.drhouseaccountancy;

import at.nacs.drhouseaccountancy.logic.Accountant;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
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
        Patient patient = accountant.convertToPatient(patientDTO);
        accountant.store(patient);
        Invoice invoice = accountant.createInvoice(patientDTO, patient);
        accountant.save(invoice);
    }

    @GetMapping("/invoices")
    List<Invoice> getAll() {
        return accountant.findAll();
    }

    @PutMapping("/invoices/{id}/paid")
    void setAsPaid(@PathVariable long id) {
        accountant.setPaid(id);
    }

}
