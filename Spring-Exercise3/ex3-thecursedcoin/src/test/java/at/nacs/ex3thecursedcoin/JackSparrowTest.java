package at.nacs.ex3thecursedcoin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JackSparrowTest {

    @Autowired
    JackSparrow jackSparrow;

    @Test
    void findCursedCoin() {
        String message = jackSparrow.findCursedCoin();
        assertEquals("I found the CursedCoin!", message);
    }
}