package at.nacs.securitydatabase.domain.repository;

import at.nacs.securitydatabase.domain.model.Participant;
import at.nacs.securitydatabase.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {
}
