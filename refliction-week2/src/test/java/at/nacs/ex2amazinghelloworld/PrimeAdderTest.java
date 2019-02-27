package at.nacs.ex2amazinghelloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PrimeAdderTest {

    @Autowired
    PrimeAdder adder;

    @Test
    void add() {
        assertEquals(24133, adder.add(100));
    }
}