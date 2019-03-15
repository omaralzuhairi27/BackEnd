package at.nacs.dutchman;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deadmanschest")
@RequiredArgsConstructor
public class DutchmanEndpoint {

    private final DeadMansChest deadMansChest;

    @GetMapping
    DeadMansChest get(){
        return deadMansChest;
    }
}
