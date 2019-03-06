package at.nacs.propertiesyml.sauna;

import at.nacs.propertiesyml.sauna.SaunaLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SaunaLoaderTest {

    @Autowired
    SaunaLoader loader;

    @Test
    void getAvailableSeats() {
        int actual = loader.getSauna().getAvailableSeats();
        assertEquals(10, actual);
    }

    @Test
    void getTemperature() {
        double actual = loader.getSauna().getTemperature();
        assertEquals(70.1, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "10, 70.1"
    })
    void getTemperatureAndAvailableSeats(int expectedSeats, double expectedTemperature) {
        int actualSeats = loader.getSauna().getAvailableSeats();
        double actualTemp = loader.getSauna().getTemperature();

        assertEquals(expectedSeats, actualSeats);
        assertEquals(expectedTemperature, actualTemp);
    }
}