package at.nacs.socialnetwork;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonManager {

    private final PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }
    public Person findAllById(Long id) {
        return repository.findAllById(id);
    }

    public List<Person> hasAFriend() {
        return repository.findAllByFriendsNotNull();
    }

    public List<Person> hasNoFriends() {
        return repository.findAllByFriends_Empty();
    }

    public Person store(Person person) {
        return repository.save(person);
    }

    public void addFriend(Long id1, Long id2) {
        Person person1 = repository.findById(id1).get();
        Person person2 = repository.findById(id2).get();
        List<Person> person1Friends = person1.getFriends();
        List<Person> person2Friends = person2.getFriends();
        person1Friends.add(person2);
        person2Friends.add(person1);
        repository.save(person1);
        repository.save(person2);
    }
    public void deleteFriend(Long id1, Long id2) {
        Person person1 = repository.findById(id1).get();
        Person person2 = repository.findById(id2).get();
        List<Person> person1Friends = person1.getFriends();
        List<Person> person2Friends = person2.getFriends();
        person1Friends.remove(person2);
        person2Friends.remove(person1);
        repository.save(person1);
        repository.save(person2);
    }
}
