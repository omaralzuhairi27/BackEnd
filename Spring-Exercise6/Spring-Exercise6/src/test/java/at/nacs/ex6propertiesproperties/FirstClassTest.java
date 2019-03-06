package at.nacs.ex6propertiesproperties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FirstClassTest {

    @Autowired
    FirstClass firstClass;

    @Test
    void getWord() {
        String actual = firstClass.getWord();
        assertEquals("fantastic", actual);
    }

    @Test
    void getNumber() {
        Integer actual = firstClass.getNumber();
        assertEquals(Integer.valueOf(369), actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0, Monday",
            "1, Tuesday",
            "6, Sunday",
    })
    void getWeekDays(int dayNumber, String dayName) {
        List<String> actual = firstClass.getWeekDays();
        List<String> expected = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

        assertEquals(7, actual.size());

        assertEquals(expected, actual);

        assertEquals("Monday", actual.get(0));

        assertEquals(actual.get(dayNumber), dayName);
    }

}