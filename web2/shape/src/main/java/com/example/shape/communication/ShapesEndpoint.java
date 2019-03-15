package com.example.shape.communication;

import com.example.shape.domain.Shape;
import com.example.shape.persistence.ShapeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shapes")
@RequiredArgsConstructor
public class ShapesEndpoint {

    private final ShapeRepository shapeRepository;

    @GetMapping
    public List <Shape> get() {
        return shapeRepository.findAll();
    }

    @GetMapping("{name")
    public Shape get(@PathVariable String name) {
        return shapeRepository.findBy(name).orElse(null);
    }

    @GetMapping
    public Shape post(@RequestBody Shape shape) {
        shapeRepository.addShape(shape);
        return shape;
    }

    @GetMapping
    public Shape put(@RequestBody Shape shape) {
        shapeRepository.updateShape(shape);
        return shape;
    }

    @GetMapping
    void delete() {
        shapeRepository.removeAll();
    }

    @GetMapping("{name}")
    void delete(@PathVariable String name) {
        shapeRepository.removeByName(name);
    }

}
