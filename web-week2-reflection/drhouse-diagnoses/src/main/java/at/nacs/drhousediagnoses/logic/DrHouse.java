package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.persistence.domain.Patient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("doctor")
public class DrHouse {

    private final RestTemplate restTemplate;

    @Value("${beds.bedsurl}")
    //@Setter
    private String bedsurl;

    @Value("${pharmacy.pharmacyurl}")
    //@Setter
    private String pharmacyurl;

    @Setter
    private Map<String, String> diagnosis;

    public Patient getDiagnosis(Patient patient) {
        String symptoms = patient.getSymptoms();
        String result = diagnosis.getOrDefault(symptoms, "headache");
        patient.setDiagnosis(result);
        if (result.equals("headache")) {
             return restTemplate.postForObject(pharmacyurl, patient, Patient.class);
        }
         return restTemplate.postForObject(bedsurl, patient, Patient.class);


    }

}