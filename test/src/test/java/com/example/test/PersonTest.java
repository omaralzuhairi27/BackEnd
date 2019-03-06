package com.example.test;


import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonTest {

    @Autowired
    Person person;
    

    @ParameterizedTest
    void getName(String expected) {
    }


}