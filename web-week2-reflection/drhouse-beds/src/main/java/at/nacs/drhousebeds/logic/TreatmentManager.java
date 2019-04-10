package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.persistence.domain.Patient;
import at.nacs.drhousebeds.persistence.repository.PatientRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class TreatmentManager {

    private final PatientRepository repository;
    private final RestTemplate restTemplate;
    private final Nurse nurse;
    @Value("${accountancy.url}")
    private String url;


    public Patient post(Patient patient) {
        Patient patient1 = nurse.setTreatment(patient);
        savePatient(patient1);
        restTemplate.postForObject(url,patient1,Patient.class);
        return patient1;
    }

    private void savePatient(Patient patient) {
        repository.save(patient);
    }

}
