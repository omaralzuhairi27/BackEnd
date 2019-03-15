package at.nacs.marathonclient.logic;

import at.nacs.marathonclient.domain.Summary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MarathonIntegrationTest {

    @Autowired
    Marathon marathon;

    @Test
    void run() {
        Summary summary = marathon.run();

        assertThat(summary).isNotNull();
        assertThat(summary.getResult()).isEqualTo("SUCCESS");
    }
}