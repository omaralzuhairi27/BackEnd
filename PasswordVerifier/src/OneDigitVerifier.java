import java.util.stream.IntStream;

public class OneDigitVerifier implements Verification {
    @Override
    public boolean isValid(String password) {
        return IntStream.range(0, password.length())
                .anyMatch(e -> Character.isDigit(password.charAt(e)));
    }
}
