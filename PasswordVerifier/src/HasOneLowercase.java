import java.util.stream.IntStream;

public class OneLowercaseLetter implements Verification {
    @Override
    public boolean isValid(String password) {
        return IntStream.range(0, password.length())
                .anyMatch(e -> Character.isLowerCase(password.charAt(e)));
    }

}
