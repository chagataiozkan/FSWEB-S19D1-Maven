package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.ApiException;
import com.workintech.s18d2.services.VegetableService;
import com.workintech.s18d2.validations.ApiValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> findAll() {
        return vegetableService.findAll();
    }

    @GetMapping("/{id}")
    public Vegetable findById(@PathVariable Long id) {
        ApiValidation.checkId(id);

        Vegetable vegetable = vegetableService.findById(id);

        if (vegetable == null) {
            log.error("Vegetable not found: {}", id);
            throw new ApiException("Vegetable not found", HttpStatus.NOT_FOUND);
        }

        return vegetable;
    }

    @GetMapping("/desc")
    public List<Vegetable> findAllDesc() {
        return vegetableService.findAllDesc();
    }

    @PostMapping
    public Vegetable save(@RequestBody Vegetable vegetable) {
        ApiValidation.checkVegetable(vegetable);
        return vegetableService.save(vegetable);
    }

    @PostMapping("/{name}")
    public List<Vegetable> findByName(@PathVariable String name) {
        return vegetableService.findByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable Long id) {
        ApiValidation.checkId(id);

        Vegetable vegetable = vegetableService.delete(id);

        if (vegetable == null) {
            throw new ApiException("Vegetable not found", HttpStatus.NOT_FOUND);
        }

        return vegetable;
    }
}