package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.communication.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Kind;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@ConfigurationProperties("treatment")
@RequiredArgsConstructor
public class InvoiceManager {

  private final InvoiceRepository invoiceRepository;

  @Setter
  private Map<String, Double> prices;

  public Invoice createInvoice(PatientDTO patientDTO, Patient patient) {
    return Invoice.builder()
                  .patient(patient)
                  .kind(getKind(patientDTO))
                  .symptoms(patientDTO.getSymptoms())
                  .diagnosis(patientDTO.getDiagnosis())
                  .provided(getProvided(patientDTO))
                  .cost(calculateCost(patientDTO))
                  .paid(false)
                  .timestamp(LocalDateTime.now())
                  .build();
  }

  public Kind getKind(PatientDTO patientDTO) {
    if (Objects.equals(patientDTO.getMedicine(), null)) {
      return Kind.TREATMENT;
    }
    return Kind.MEDICINE;
  }

  public String getProvided(PatientDTO patientDTO) {
    if (Objects.equals(patientDTO.getMedicine(), null)) {
      return patientDTO.getTreatment();
    }
    return patientDTO.getMedicine();
  }

  public Double calculateCost(PatientDTO patientDTO) {
    if (Objects.equals(patientDTO.getTreatment(), null)) {
      String medicine = patientDTO.getMedicine();
      return prices.getOrDefault(medicine, null);
    }
    return prices.getOrDefault(patientDTO.getTreatment(), null);
  }

  public Invoice setPaid(Long id) {
    Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
    invoiceOptional.get().setPaid(true);
    invoiceRepository.save(invoiceOptional.get());
    return invoiceOptional.get();
  }

  public List<Invoice> findAll() {
    return invoiceRepository.findAll();
  }

  public void save(Invoice invoice) {
    invoiceRepository.save(invoice);
  }

  public void delete(long id) {
    Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
    invoiceRepository.delete(invoiceOptional.get());

  }
}
