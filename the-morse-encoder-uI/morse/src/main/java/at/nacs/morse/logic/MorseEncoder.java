package at.nacs.morse.logic;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Getter
@ConfigurationProperties("morse")
public class MorseEncoder {

  @Setter
  private Map<String, String> morseAlphabet;

  public String encode(String letter) {
    String lowerCase = letter.toLowerCase();
    return morseAlphabet.getOrDefault(lowerCase, "Wrong");
  }

}
