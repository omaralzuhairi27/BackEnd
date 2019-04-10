import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordVerifierTest {
    @ParameterizedTest
    @CsvSource({
            "0,,false",
            "1,1,true",
            "2,123456789,true",
            "3,a,true",
            "4,A,true"
    })
    void testAllRules(int position,String password, boolean expected) {
        List<Verification> verifications = Verifications.asList();
        boolean actual = verifications.get(position).isValid(password);
        assertEquals(actual, expected);
    }

    private PasswordVerifier passwordVerifier = new PasswordVerifier();

    @ParameterizedTest
    @CsvSource({
            ",false",
            "1aA,fales",
            "A23456789,fales",
            "a,false",
            " ,false"
    })
    void part1(String password, boolean expected) {
        boolean actual = passwordVerifier.part1(password);
        assertEquals(actual, expected);

    }

    @ParameterizedTest
    @CsvSource({
            "1aA,true",
            "A23456789,true",
            "a,false",
            "aA,true",
            ",false"
    })
    void part2(String password, boolean expected) {
        boolean actual = passwordVerifier.part2(password);
        assertEquals(actual, expected);

    }

    @ParameterizedTest
    @CsvSource({
            "1aA,true",
            "A23456789,flse",
            "a,true",
            "aA,true"
    })
    void part3(String password, boolean expected) {
        boolean actual = passwordVerifier.part3(password);
        assertEquals(actual, expected);
    }
}