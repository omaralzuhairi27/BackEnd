package at.nacs.morse;


import at.nacs.morse.logic.MorseEncoder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class MorseEncoderTest {

  @Autowired
  MorseEncoder morseEncoder;

  @ParameterizedTest
  @CsvSource({
      " a , .- ",
      " b , -...",
      " 0 , -----",
      " 1 , .----",
      " 5 , ....."
  })
  void encode(String letter, String expected) {
    String actual = morseEncoder.encode(letter);
    Assertions.assertEquals(actual, expected);
  }
}