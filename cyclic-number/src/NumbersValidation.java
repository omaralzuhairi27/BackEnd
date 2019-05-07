import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class NumbersValidation {
  public boolean hasSameDigits(String firstNumber,String secondNumber) {

    List<String> first= Arrays.asList(firstNumber.split(""));
    List<String> second= Arrays.asList(secondNumber.split(""));
    first.sort(Comparator.naturalOrder());
    second.sort(Comparator.naturalOrder());
    return first==second;
  }

}
