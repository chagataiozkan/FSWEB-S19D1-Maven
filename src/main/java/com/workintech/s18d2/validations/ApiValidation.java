package com.workintech.s18d2.validations;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class ApiValidation {

    public static void checkId(Long id) {
        if (id == null || id <= 0) {
            throw new ApiException("Id must be greater than zero", HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkFruit(Fruit fruit) {
        if (fruit == null ||
                fruit.getName() == null ||
                fruit.getName().isBlank() ||
                fruit.getPrice() == null ||
                fruit.getPrice() <= 0 ||
                fruit.getFruitType() == null) {

            throw new ApiException("Fruit data is invalid", HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkVegetable(Vegetable vegetable) {
        if (vegetable == null ||
                vegetable.getName() == null ||
                vegetable.getName().isBlank() ||
                vegetable.getPrice() == null ||
                vegetable.getPrice() <= 0) {

            throw new ApiException("Vegetable data is invalid", HttpStatus.BAD_REQUEST);
        }
    }
}