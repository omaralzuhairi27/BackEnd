package at.nacs.drhousediagnoses.communication;

import at.nacs.drhousediagnoses.domian.Patient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PaientEndpoint {

    @PostMapping
    Patient post(@RequestBody Patient patient) {
        return patient;
    }
}

