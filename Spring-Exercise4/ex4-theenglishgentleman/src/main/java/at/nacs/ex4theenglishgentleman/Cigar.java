package at.nacs.ex4theenglishgentleman;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Cigar {
    private boolean lit=false;


    public void smoke() throws CigarWasNotLitException {
        if (!lit) {
            throw new CigarWasNotLitException();
        }
    }
}
