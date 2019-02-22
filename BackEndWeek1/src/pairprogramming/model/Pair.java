package pairprogramming.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Pair {
    
    private List<Participant> participants;

}
