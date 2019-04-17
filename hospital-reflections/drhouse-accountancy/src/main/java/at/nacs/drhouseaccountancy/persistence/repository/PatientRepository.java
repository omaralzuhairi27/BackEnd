package at.nacs.drhouseaccountancy.persistence.repository;


import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
