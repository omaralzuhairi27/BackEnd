package at.nacs.fengshui;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FengShuiEndpoint {

    private final FengShui fengShui;


    @GetMapping("/{birthday}")
    String getSign(@PathVariable LocalDate birthday) {
        return fengShui.getSign(birthday);
    }

    @GetMapping("/compatibility/love/{birthday1}/{birthday2}")
    String getLove(@PathVariable("birthday1") LocalDate birthday1, @PathVariable("birthday2") LocalDate birthday2) {
        return fengShui.findLoveCompatibility(birthday1, birthday2);
    }

    @GetMapping("/compatibility/sign/{birthday1}/{birthday2}")
    String getSign(@PathVariable("birthday1") LocalDate birthday1, @PathVariable("birthday2") LocalDate birthday2) {
        return fengShui.findSignCompatibility(birthday1, birthday2);
    }
}
