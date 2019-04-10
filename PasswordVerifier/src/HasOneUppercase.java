import java.util.stream.IntStream;

public class OneUppercaseLetter implements Verification {
    @Override
    public boolean isValid(String password) {
        return IntStream.range(0, password.length())
                .anyMatch(e -> Character.isUpperCase(password.charAt(e)));
    }
}
