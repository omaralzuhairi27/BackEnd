package at.nacs.encoder.communication;

import at.nacs.encoder.logic.Encode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encode")
@RequiredArgsConstructor
public class EncodeEndpoint {

  private final Encode encode;

  @PostMapping
  String get(@RequestBody String message) {
    return encode.post(message);

  }
}
