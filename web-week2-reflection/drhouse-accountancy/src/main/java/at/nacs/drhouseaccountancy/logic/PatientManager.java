package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.domain.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientManager {

  private final PatientRepository patientRepository;

  public void store(Patient patient) {
    patientRepository.save(patient);
  }

  public Patient convertToPatient(PatientDTO patientDTO) {
    return Patient.builder()
                  .uuid(patientDTO.getId())
                  .name(patientDTO.getName())
                  .build();
  }

}
