package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.validations.ApiValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/fruit")
public class FruitController {

    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> findAll() {
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit findById(@PathVariable Long id) {

        ApiValidation.checkId(id);

        Fruit fruit = fruitService.getById(id);

        if (fruit == null) {
            log.error("Fruit not found: {}", id);
            throw new PlantException("Fruit not found", HttpStatus.NOT_FOUND);
        }

        return fruit;
    }

    @GetMapping("/desc")
    public List<Fruit> findAllDesc() {
        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public Fruit save(@RequestBody Fruit fruit) {

        ApiValidation.checkFruit(fruit);

        return fruitService.save(fruit);
    }

    @GetMapping("/name/{name}")
    public List<Fruit> findByName(@PathVariable String name) {
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable Long id) {

        ApiValidation.checkId(id);

        Fruit fruit = fruitService.delete(id);

        if (fruit == null) {
            throw new PlantException("Fruit not found", HttpStatus.NOT_FOUND);
        }

        return fruit;
    }
}