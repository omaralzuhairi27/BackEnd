package at.nacs.phonebook.persistence.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
