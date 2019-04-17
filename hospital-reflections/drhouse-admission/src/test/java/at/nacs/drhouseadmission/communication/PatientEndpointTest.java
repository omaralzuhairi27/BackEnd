package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PatientEndpointTest {


    @Autowired
    TestRestTemplate restTemplate;
    private String url = "/patients";

    @Test
    void post() {
        Patient expected = new Patient();
        expected.setName("Omar");
        expected.setSymptoms("Cough");
        Patient actual = restTemplate.postForObject(url, expected, Patient.class);
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getSymptoms()).isEqualTo(expected.getSymptoms());
        assertThat(actual.getId()).isNotEmpty();
    }
}