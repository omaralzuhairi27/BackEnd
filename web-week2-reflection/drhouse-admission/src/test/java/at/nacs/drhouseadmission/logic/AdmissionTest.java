package at.nacs.drhouseadmission.logic;

import at.nacs.drhouseadmission.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AdmissionTest {
    @Autowired
    Admission admission;

    @Test
    void post() {
        Patient expected = new Patient();
        expected.setName("Omar");
        expected.setSymptoms("Cough");
        Patient actual = admission.post(expected);
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getSymptoms()).isEqualTo(expected.getSymptoms());
        assertThat(actual.getId()).isNotEmpty();

    }
}