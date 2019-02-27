package at.nacs.ex5thecalculator.model;

public interface Operation {

    public boolean matches(Expression expression);

    public Double apply(Expression expression);
}
