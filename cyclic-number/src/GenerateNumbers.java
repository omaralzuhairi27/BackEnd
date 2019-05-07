import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateNumbers {
  public static List<Integer> generatNumber() {
    return IntStream.range(100000, 999999)
             .mapToObj(e -> e)
             .collect(Collectors.toList());
  }
}


