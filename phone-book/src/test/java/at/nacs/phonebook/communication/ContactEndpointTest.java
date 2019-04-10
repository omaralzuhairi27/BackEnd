package at.nacs.phonebook.communication;

import at.nacs.phonebook.logic.ContactManager;
import at.nacs.phonebook.persistence.domain.Contact;
import at.nacs.phonebook.persistence.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContactEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;
    @SpyBean
    ContactManager manager;
    @MockBean
    ContactRepository repository;
    private String url = "/contacts";

    @Test
    void getAll() {
        restTemplate.getForObject(url, Contact[].class);
        Mockito.verify(manager).findAll();
    }


    @Test
    void insertContact() {

        Contact contact = new Contact();
        restTemplate.postForObject(url, contact, Contact.class);
        Mockito.verify(manager).saveContact(contact);

    }

    @Test
    void getAllContactByAddress() {
    }
}