package at.nacs.ex3thecursedcoin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LegendaryCompass {
    public final CursedCoin cursedCoin;

    public String getCursedCoinName(){
        return cursedCoin.getClass().getSimpleName();
    }


}
