package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Accountant {

  private final PatientManager patientManager;
  private final InvoiceManager invoiceManager;

  public Invoice store(PatientDTO patientDTO) {
    Patient patient = patientManager.convertToPatient(patientDTO);
    patientManager.store(patient);
    Invoice invoice = invoiceManager.createInvoice(patientDTO, patient);
    invoiceManager.save(invoice);
    return invoice;

  }

  public Invoice setPaid(Long id) {
    return invoiceManager.setPaid(id);
  }

  public List<Invoice> getAll() {
    return invoiceManager.findAll();
  }

  public void delete(long id) {
    invoiceManager.delete(id);
  }

}