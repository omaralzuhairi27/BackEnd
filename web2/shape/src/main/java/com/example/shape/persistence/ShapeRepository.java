package com.example.shape.persistence;

import com.example.shape.domain.Shape;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ShapeRepository {

    private List <Shape> shapes=new ArrayList <>();

    public List<Shape> findAll(){
        return shapes;
    }

    public Optional<Shape> findBy(String name){
       return shapes.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst();
    }

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    public void updateShape(Shape shape){
        Optional <Shape> existing = shapes.stream()
                .filter(e -> e.getName().equals(shape.getName()))
                .findFirst();
        existing.ifPresent(e -> e.setColor(shape.getColor()));
    }

    public void removeAll(){
        shapes.clear();
    }
    public void removeByName(String name){
        shapes.removeIf(e -> e.getName().equals(name));
    }
}
