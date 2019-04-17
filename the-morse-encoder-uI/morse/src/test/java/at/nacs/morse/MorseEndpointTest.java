package at.nacs.morse;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MorseEndpointTest {

  @Autowired
  TestRestTemplate restTemplate;

  String url = "/morse";

  @ParameterizedTest
  @CsvSource({
      " a , .-    ",
      " b , -...  ",
      " 0 , ----- ",
      " 1 , .---- ",
      " 5 , ..... ",
      " r , .-.   ",
      " s , ...   ",
      " t , -     ",
      " u , ..-   ",
      " v , ...-  ",
      " w , .--   "
  })
  void encode(String letter, String expected) {
    String actual = restTemplate.postForObject(url, letter, String.class);
    assertThat(actual).isEqualTo(expected);
  }
}