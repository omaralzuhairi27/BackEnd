package at.nacs.drhouseaccountancy.persistence.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class PatientDTO {

    private String id;
    private String name;
    private String symptoms;
    private String diagnosis;
    private String treatment;
    private String medicine;
}
