import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CyclicNumber {

  private NumbersValidation numbersValidation=new NumbersValidation();
  private MultiplyWithInput multiplyWithInput=new MultiplyWithInput();
  private Scanner scanner = new Scanner(System.in);

  public List<String> findCyclicNumber() {

    List<String> firstList = multiplyWithInput.multiplyWithInput(2);
    List<String> secoundList = multiplyWithInput.multiplyWithInput(3);

    for (int i = 0; i <firstList.size() ; i++) {
        if(numbersValidation.hasSameDigits("142857",firstList.get(i))){
          System.out.println(firstList.get(i));
        }
    }
  return firstList.stream()
           .flatMap(e1 -> secoundList.stream()
           .filter(e2 -> numbersValidation.hasSameDigits(e1,e2)))
           .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    CyclicNumber cyclicNumber=new CyclicNumber();
    cyclicNumber.findCyclicNumber();

  }

}
/*for (int i = 0; i <firstList.size() ; i++) {
      for (int j = 0; j <secoundList.size() ; j++) {
        if(numbersValidation.hasSameDigits(firstList.get(i),secoundList.get(j))){
          newList.add(secoundList.get(j));
        }
      }

    }
    return newList;*/