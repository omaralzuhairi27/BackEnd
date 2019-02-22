package coffeecan.controller.experiment.refill;

import coffeecan.model.Bean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RefillTest {

    @ParameterizedTest
    @CsvSource({
            "white, white, black",
            "white, black, white",
            "black, white, white",
            "black, black, black",
    })
    void get(String expectedColor, String color1, String color2) {
        Bean bean1 = new Bean(color1);
        Bean bean2 = new Bean(color2);

        Bean result = Refill.get(bean1, bean2);

        Bean expected = new Bean(expectedColor);
        Assertions.assertEquals(expected, result);
    }
}