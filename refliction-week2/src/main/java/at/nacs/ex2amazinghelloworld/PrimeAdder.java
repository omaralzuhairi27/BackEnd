package at.nacs.ex2amazinghelloworld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class PrimeAdder {

    private final Primes primes;

    public int add(Integer number) {
        return IntStream.iterate(0, i -> i + 1)
                .filter(e -> primes.isPrime(e))
                .limit(number)
                .reduce(0, (a, b) -> a + b);
    }
}
