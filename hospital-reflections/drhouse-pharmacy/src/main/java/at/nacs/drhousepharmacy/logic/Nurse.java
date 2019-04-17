package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.persistence.domain.Patient;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@ConfigurationProperties("pharmacy")
public class Nurse {
  @Setter
  private Map<String, String> medicine;

  public Patient giveRightMedicine(Patient patient) {
    String result = medicine.getOrDefault(patient.getDiagnosis(), "nothing");
    patient.setMedicine(result);
    return patient;
  }

}
