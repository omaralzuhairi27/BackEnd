import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicateNumber {
  public boolean removeDuplicateNumber(String number) {
    String collect = Arrays.stream(number.split(""))
                           .distinct()
                           .collect(Collectors.joining());
                return number.length()==collect.length();
  }
}
