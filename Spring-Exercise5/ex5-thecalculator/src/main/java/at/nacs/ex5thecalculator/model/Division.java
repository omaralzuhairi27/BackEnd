package at.nacs.ex5thecalculator.model;

import org.springframework.stereotype.Component;

@Component
public class Division implements Operation {
    @Override
    public boolean matches(Expression expression) {
        return expression.getSymbol().equals("/");
    }

    @Override
    public Double apply(Expression expression) {
        if(expression.getNumber2()==0){
            return Double.POSITIVE_INFINITY;
        }
        return expression.getNumber1() / expression.getNumber2() ;
    }
}
