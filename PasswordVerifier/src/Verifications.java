import java.util.Arrays;
import java.util.List;

public class Verifications {

    private static List<Verification> verifications= Arrays.asList(
            new NotNull(),
            new HaveOneDigit(),
            new LargerEightChars(),
            new OneLowercaseLetter(),
            new OneUppercaseLetter());

    public static List<Verification> asList() {
        return verifications;
    }
}
