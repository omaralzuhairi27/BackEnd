import java.util.Arrays;
import java.util.List;

public class Verifications {

    private static List<Verification> verifications= Arrays.asList(
            new NotNullVerifier(),
            new OneDigitVerifier(),
            new LargerEightChars(),
            new OneLowercaseVerifier(),
            new OneUppercaseLetter());

    public static List<Verification> asList() {
        return verifications;
    }
}
