package at.nacs.marathonclient.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Summary {

    private String result;
    private Runner expectedWinner;
    private Runner actualWinner;
    private List<Runner> runners;

}
