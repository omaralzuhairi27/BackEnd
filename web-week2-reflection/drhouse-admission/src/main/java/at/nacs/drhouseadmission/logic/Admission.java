package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class Admission {

    private final RestTemplate restTemplate;
    @Value("${diagnoses.url}")
    private String url;

    public Patient post(Patient patient) {
        String id = UUID.randomUUID().toString();
        patient.setId(id);
        return restTemplate.postForObject(url, patient, Patient.class);

    }
}
