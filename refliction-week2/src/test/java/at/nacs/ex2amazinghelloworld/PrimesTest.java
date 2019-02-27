package at.nacs.ex2amazinghelloworld;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PrimesTest {

    @Autowired
     Primes primes;
    @Test
    void isPrime() {
        assertTrue(primes.isPrime(7));
    }

    @ParameterizedTest
    @CsvSource({
            "1,false",
            "3,true",
            "8,false",
            "7,true",
            "0,false",
    })

    void matches( int number,boolean expected) {
    boolean result=primes.isPrime(number);
        assertEquals(expected, result);
    }


}