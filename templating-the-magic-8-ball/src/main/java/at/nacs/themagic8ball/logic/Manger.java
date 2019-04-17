package at.nacs.themagic8ball.logic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class Manger {

  public String getMessage(){

    List<String> messages=new ArrayList<>();
    messages.add("one message");
    messages.add("two message");
    messages.add("three message");
    messages.add("four message");
    messages.add("five message");
    messages.add("six message");
    messages.add("seven message");
    messages.add("eight message");

    Collections.shuffle(messages);
    return messages.get(0);

  }

}
