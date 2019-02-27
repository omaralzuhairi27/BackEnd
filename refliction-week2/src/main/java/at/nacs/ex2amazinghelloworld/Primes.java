package at.nacs.ex2amazinghelloworld;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Scope("prototype")
@Component

public class Primes {
    public Boolean isPrime(Integer number) {
        return number > 1 && IntStream.range(2, number)
                .noneMatch(index -> number % index == 0);
    }
}
