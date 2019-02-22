package coffeecan.controller.bean;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BeansTest {

    @ParameterizedTest
    @CsvSource({
            "white",
            "black"
    })
    void filter(String color) {
        assertEquals(color, Beans.filter(color).getColor());
    }


    @Test
    void getWhite() {
        assertEquals("white", Beans.getWhite().getColor());
    }

    @Test
    void getBlack() {
        assertEquals("black", Beans.getBlack().getColor());
    }
}