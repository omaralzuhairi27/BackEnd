package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.persistence.domain.Patient;
import at.nacs.drhousepharmacy.persistence.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ApothecaryManager {

    private final PatientRepository repository;
    private final RestTemplate restTemplate;
    private final Nurse nurse;

    @Value("${accountancy.url}")
    private String url;

    public Patient post(Patient patient) {
        Patient patient1 = nurse.giveRightMedicine(patient);
        savePatient(patient1);
        restTemplate.postForObject(url,patient1,Patient.class);
        return patient1;
    }

    private void savePatient(Patient patient) {
        repository.save(patient);
    }

}
