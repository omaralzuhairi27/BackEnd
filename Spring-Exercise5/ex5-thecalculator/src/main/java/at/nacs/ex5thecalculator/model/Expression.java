package at.nacs.ex5thecalculator.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Expression {
    private double number1;
    private String symbol;
    private double number2;
}
