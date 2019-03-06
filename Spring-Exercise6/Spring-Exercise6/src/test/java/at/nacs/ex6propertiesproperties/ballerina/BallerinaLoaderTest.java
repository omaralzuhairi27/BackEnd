package at.nacs.ex6propertiesproperties.ballerina;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BallerinaLoaderTest {

    @Autowired
    BallerinaLoader loader;

    @ParameterizedTest
    @CsvSource({
            "Tamara, 5",
            "Niklas, 5",
            "You, 1",
    })
    void testBallerina(String name, int performance) {
        List<Ballerina> ballerinas = loader.getBallerinas();

        assertEquals(3, ballerinas.size());

        boolean doAllNamesMatch = ballerinas.stream()
                .anyMatch(e -> Objects.equals(e.getName(), name));
        assertTrue(doAllNamesMatch);

        boolean doAllScoresMatch = ballerinas.stream()
                .anyMatch(e -> Objects.equals(e.getPerformanceQuality(), performance));
        assertTrue(doAllScoresMatch);
    }
}