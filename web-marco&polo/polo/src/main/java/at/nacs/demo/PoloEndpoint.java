package at.nacs.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PoloEndpoint {

    @PostMapping("/polo")
    String post(@RequestBody String message){
        return message.equals("Marco")
                ? "Polo"
                : "What";
    }
}
