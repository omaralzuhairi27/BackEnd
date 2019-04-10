package at.nacs.phonebook;

import at.nacs.phonebook.logic.ContactManager;
import at.nacs.phonebook.persistence.domain.Contact;
import at.nacs.phonebook.persistence.repository.ContactRepository;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ConfigurationProperties("data")
class ContactManagerTest {

    @Autowired
    ContactRepository repository;

    @Autowired
    ContactManager manager;

    @Setter
    Contact contact1;
    @Setter
    Contact contact2;
    @Setter
    Contact contact3;
    @BeforeEach
    void before(){
        repository.deleteAll();
        repository.save(contact1);
        repository.save(contact2);
    }

    @Test
    void findAll() {
        List<Contact> all = manager.findAll();
        assertThat(all.size()).isEqualTo(2);
    }

    @Test
    void saveContact() {
        Contact contact = manager.saveContact(contact3);
        assertThat(contact.getName()).isEqualTo("rabi");

    }

    @Test
    void findContact() {
        List<Contact>  contacts= manager.findContact("rechte");
        assertThat(contacts.size()).isEqualTo(2);

    }
}