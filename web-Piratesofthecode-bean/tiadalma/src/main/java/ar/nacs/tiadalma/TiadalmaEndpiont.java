package ar.nacs.tiadalma;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dutchman")
public class TiadalmaEndpiont {

    @Value("${dutchman.url}")
    private String url;

    @GetMapping
    String get() {
        return url;
    }

}
