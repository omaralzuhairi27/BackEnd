package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Kind;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.domain.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.repository.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistence.repository.PatientRepository;
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
@RequiredArgsConstructor
@ConfigurationProperties("treatment")
public class Accountant {

    private final PatientRepository patientRepository;
    private final InvoiceRepository invoiceRepository;

    @Setter
    private Map<String, Double> prices;

    public void store(Patient patient) {
        patientRepository.save(patient);
    }

    public Double calculateCost(PatientDTO patientDTO) {
        if (Objects.equals(patientDTO.getTreatment(), null)) {
            String medicine = patientDTO.getMedicine();
            return prices.getOrDefault(medicine, null);
        }
        return prices.getOrDefault(patientDTO.getTreatment(), null);
    }

    public String provided(PatientDTO patientDTO) {
        if (Objects.equals(patientDTO.getMedicine(), null)) {
            return "treatment";
        }
        return "medicine";
    }

    public Kind getKind(PatientDTO patientDTO) {
        if (Objects.equals(patientDTO.getMedicine(), null)) {
            return Kind.TREATMENT;
        }
        return Kind.MEDICINE;
    }

    public Invoice createInvoice(PatientDTO patientDTO, Patient patient) {



        return Invoice.builder()
                .patient(patient)
                .kind(getKind(patientDTO))
                .symptoms(patientDTO.getSymptoms())
                .diagnosis(patientDTO.getDiagnosis())
                .provided(provided(patientDTO))
                .cost(calculateCost(patientDTO))
                .paid(false)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public Patient convertToPatient(PatientDTO patientDTO) {
        return Patient.builder()
                .uuid(patientDTO.getId())
                .name(patientDTO.getName())
                .build();
    }

    public void setPaid(Long id) {
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
        invoiceOptional.get().setPaid(true);
    }

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }


    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }


}