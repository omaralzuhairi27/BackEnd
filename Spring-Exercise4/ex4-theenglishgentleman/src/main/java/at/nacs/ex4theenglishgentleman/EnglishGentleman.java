package at.nacs.ex4theenglishgentleman;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class EnglishGentleman {
    private final Monocle monocle;
    private final Lighter lighter;


    @Getter
    private boolean smoke;
    @Getter
    private boolean read;



    public void smoke(Cigar cigar) throws CigarWasNotLitException {
        lighter.smoke(cigar);
        cigar.smoke();
        smoke=true;
    }



    public void read(Newspaper newspaper) {
        monocle.read(newspaper);
        read=true;
    }

    public boolean hadAGoodDay() {
        return smoke && read;
    }


}
