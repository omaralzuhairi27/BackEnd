package at.nacs.phonebook.logic;

import at.nacs.phonebook.persistence.domain.Contact;
import at.nacs.phonebook.persistence.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactManager {

    private final ContactRepository contactRepository;

    public List<Contact> findAll(){
        return contactRepository.findAll();
    }

    public Contact saveContact(Contact contact){
        return contactRepository.save(contact);
    }

    public List<Contact> findContact(String address){
        return contactRepository.findAllByAddress_NameLike(address);
    }


}
