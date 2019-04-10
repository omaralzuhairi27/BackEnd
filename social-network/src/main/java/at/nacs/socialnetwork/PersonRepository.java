package at.nacs.socialnetwork;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Long> {
   // List<Person> findAllByFriends();
    Person findAllById(Long id);

    List<Person> findAllByFriendsNotNull();
    List<Person> findAllByFriends_Empty();

    Optional<Person> findById(Long id);
}
