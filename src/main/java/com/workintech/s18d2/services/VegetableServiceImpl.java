package com.workintech.s18d2.services;

import com.workintech.s18d2.repository.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetableServiceImpl implements VegetableService {

    private VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public Vegetable findById(Long id) {
        return vegetableRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vegetable> findAllDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public List<Vegetable> findByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable vegetable = findById(id);

        if (vegetable != null) {
            vegetableRepository.delete(vegetable);
        }

        return vegetable;
    }
}