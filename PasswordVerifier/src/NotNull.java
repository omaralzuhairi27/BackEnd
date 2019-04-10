import java.util.Objects;
import java.util.stream.IntStream;

public class NotNull implements Verification {
    @Override
    public boolean isValid(String password) {
       return password!=null;
    }
}
