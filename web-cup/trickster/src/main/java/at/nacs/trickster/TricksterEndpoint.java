package at.nacs.trickster;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TricksterEndpoint {

    private final Trickster trickster;

    @GetMapping("/play")
    String play() {
        return trickster.play();
    }

    @GetMapping("/choose/{number}")
    boolean choose(@PathVariable int number) {
        return trickster.choose(number);
    }
}
