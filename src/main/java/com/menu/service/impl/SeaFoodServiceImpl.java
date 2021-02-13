package com.menu.service.impl;

import com.menu.document.SeaFood;
import com.menu.repository.SeaFoodRepository;
import com.menu.service.SeaFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeaFoodServiceImpl implements SeaFoodService<SeaFood> {
    @Autowired
    private SeaFoodRepository seaFoodRepository;

    @Override
    public List<SeaFood> findAll() {
        return null;
    }

    @Override
    public SeaFood findById(Long seafoodId) {
        return null;
    }

    @Override
    public void delete(Long SeaFoodId) {

    }

    @Override
    public SeaFood findByName(String name) {
        return null;
    }

    @Override
    public SeaFood save(SeaFood newSeaFood) {
        return null;
    }

    @Override
    public SeaFood update(Long seafoodId, SeaFood updateSeaFood) {
        return null;
    }
}
