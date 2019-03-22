package at.nacs.cup;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CupTest {

    @Autowired
    Cup cup;

//    @BeforeAll
//    void before() {
//        cup.removeCoin();
//    }

    @Test
    void hasCoin() {
        assertFalse(cup.hasCoin());
    }

    @Test
    void putCoin() {
        cup.putCoin();
        assertTrue(cup.hasCoin());
    }

    @Test
    void removeCoin() {
        cup.putCoin();
        assertTrue(cup.hasCoin());
        cup.removeCoin();
        assertFalse(cup.hasCoin());
    }
}