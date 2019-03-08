package at.nasc.demo;

import at.nasc.demo.logic.SecretCode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class SecretCodeTest {

    @Autowired
    SecretCode secretCode;

    static Stream <Arguments> generateData() {
        return Stream.of(
                Arguments.of(19559, Arrays.asList("thousand knuckles", "tickles over palm")),
                Arguments.of(324, Arrays.asList("little finger grab", "thumb touches back")),
                Arguments.of(193423559, Arrays.asList("thousand knuckles", "tickles over palm", "little finger grab", "thumb touches back")),
                Arguments.of(111111, Arrays.asList())
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void testGetTheSecretCode(Integer number, List <String> expected) {
        Set <String> expectedSet = new HashSet <>(expected);
        Set <String> actual = secretCode.getTheSecretCode(number);
        assertEquals(actual, expectedSet);
    }
}