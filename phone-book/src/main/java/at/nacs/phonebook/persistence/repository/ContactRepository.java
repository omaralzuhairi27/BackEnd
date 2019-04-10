package at.nacs.phonebook.persistence.repository;

import at.nacs.phonebook.persistence.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findAllByAddress_NameLike(String address);
}
