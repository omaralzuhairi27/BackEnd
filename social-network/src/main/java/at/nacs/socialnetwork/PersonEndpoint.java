package at.nacs.socialnetwork;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonEndpoint {
    private final PersonManager manager;

    @GetMapping
    List<Person> getAll() {
        return manager.findAll();
    }
    @GetMapping("/{id}")
    Person geAPerson(@PathVariable Long id) {
        return manager.findAllById(id);
    }

    @GetMapping("/friends/with")
    List<Person> hasAtLeastOneFriend() {
        return manager.hasAFriend();
    }

    @GetMapping("/friends/without")
    List<Person> hasNoFriend() {
        return manager.hasNoFriends();
    }

    @PostMapping
    Person save(@RequestBody Person person) {
        return manager.store(person);
    }

    @PutMapping("/{id1}/friend/{id2}")
    void addFriend(@PathVariable Long id1, @PathVariable Long id2) {
        manager.addFriend(id1, id2);
    }

    @PutMapping("/{id1}/unfriend/{id2}")
    void deletFriend(@PathVariable Long id1, @PathVariable Long id2) {
        manager.deleteFriend(id1, id2);
    }
}
