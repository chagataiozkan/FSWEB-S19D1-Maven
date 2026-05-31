package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {

    List<Vegetable> findAll();

    Vegetable findById(Long id);

    List<Vegetable> findAllDesc();

    Vegetable save(Vegetable vegetable);

    List<Vegetable> findByName(String name);

    Vegetable delete(Long id);
}