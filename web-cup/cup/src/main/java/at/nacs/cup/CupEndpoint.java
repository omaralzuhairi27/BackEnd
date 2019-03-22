package at.nacs.cup;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coin")
@RequiredArgsConstructor
public class CupEndpoint {
    private final Cup cup;

    @GetMapping
    Boolean get(){
       return cup.hasCoin();
    }
    @PutMapping
    void put(){
        cup.putCoin();
    }
    @DeleteMapping
    void delete(){
        cup.removeCoin();
    }
}
