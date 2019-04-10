package at.nacs.phonebook.communication;

import at.nacs.phonebook.logic.ContactManager;
import at.nacs.phonebook.persistence.domain.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/contacts")
@RestController
@RequiredArgsConstructor
public class ContactEndpoint {

    private final ContactManager manager;

    @GetMapping
    List<Contact> getAll(){
        return manager.findAll();
    }

    @PostMapping
    Contact insertContact(@RequestBody Contact contact){
        return manager.saveContact(contact);
    }
    @GetMapping("/address/{address}")
    List<Contact> getAllContactByAddress(@PathVariable String address){
        return manager.findContact(address);

    }
}
