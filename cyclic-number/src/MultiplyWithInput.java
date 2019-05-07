import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplyWithInput {
  List<Integer> baseNumbers = GenerateNumbers.generatNumber();
  private  RemoveDuplicateNumber removeDuplicateNumber=new RemoveDuplicateNumber();

  public List<String> multiplyWithInput(Integer number) {
    List<Integer> numbers = new ArrayList<>(baseNumbers);
    return numbers.stream()
                  .map(e -> e * number)
                  .map(String::valueOf)
                  .filter(e -> e.length() == 6)
                  .filter(e -> removeDuplicateNumber.removeDuplicateNumber(e))
                  .collect(Collectors.toList());
  }
}
