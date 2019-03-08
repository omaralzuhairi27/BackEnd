package at.nacs.cinemamessagetemplate.logic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TemplateEngineTest {

    @Autowired
    TemplateEngine templateEngine;

    @ParameterizedTest
    @CsvSource({
            "Good day SIR Mr. Omar!, Mr. Omar",
            "Dear MISS/MISSIS Mrs. Doubtfire!, Mrs. Doubtfire",
            "My dearest FAMILY John Threepwood!, John Threepwood",
            "My dearest FAMILY Mrs. Alice Threepwood!, Mrs. Alice Threepwood",
            "Hello NORMAL Paulius!, Paulius",
    })
    void matchTemplateTo(String expected, String name) {
        String actual = templateEngine.getMatchingTemplate(name);
        assertEquals(expected, actual);
    }
}