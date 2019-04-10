package at.nacs.socialnetwork;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = "friends")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;


    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Person> friends = new ArrayList<>();

}
