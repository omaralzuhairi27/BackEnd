package at.nacs.marathonclient.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@NoArgsConstructor
public class Runner {

    private String name;
    private Duration time;

}
