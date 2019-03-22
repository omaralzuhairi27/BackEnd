package at.nacs.cup;

import org.springframework.stereotype.Service;

@Service
public class Cup {
    private boolean coin;

    Boolean hasCoin() {
        return coin;
    }

    void putCoin() {
        coin = true;
    }

    void removeCoin() {
        coin = false;
    }


}
