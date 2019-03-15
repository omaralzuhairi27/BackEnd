package at.nacs.dutchman;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class DeadMansChest {
    @Value("${deadmanschest.item}")
    private String item;
}
