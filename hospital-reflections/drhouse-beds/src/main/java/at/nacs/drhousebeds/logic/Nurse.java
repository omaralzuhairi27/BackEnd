package at.nacs.drhousebeds.logic;

import at.nacs.drhousebeds.persistence.domain.Patient;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@ConfigurationProperties("nurse")
public class Nurse {

    @Setter
    private Map<String, String> treatments;

    Patient setTreatment(Patient patient) {
        String result = treatments.getOrDefault(patient.getDiagnosis(), "lupus");
        patient.setTreatment(result);
        return patient;
    }

}
