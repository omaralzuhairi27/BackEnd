package at.nacs.drhousepharmacy.communication;

import at.nacs.drhousepharmacy.logic.ApothecaryManager;
import at.nacs.drhousepharmacy.persistence.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientEndpoint {

    private final ApothecaryManager manager;

    @PostMapping
    Patient post(@RequestBody Patient patient){
        return manager.post(patient);
    }
}
