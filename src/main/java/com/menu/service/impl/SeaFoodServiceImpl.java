package com.menu.service.impl;

import com.menu.document.SeaFood;
import com.menu.repository.SeaFoodRepository;
import com.menu.service.SeaFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;
import static org.springframework.web.client.HttpClientErrorException.*;

@Service
public class SeaFoodServiceImpl implements SeaFoodService<SeaFood> {
    @Autowired
    private SeaFoodRepository seaFoodRepository;

    public SeaFoodServiceImpl(SeaFoodRepository seaFoodRepository) {
        this.seaFoodRepository = seaFoodRepository;
    }

    @Override
    public List<SeaFood> findAll() {
        return seaFoodRepository.findAll();
    }

    @Override
    public Optional<SeaFood> findById(Long seafoodId) {
        return ofNullable(seaFoodRepository.findById(seafoodId)
                .orElseThrow(()-> new IndexOutOfBoundsException()));
    }

    @Override
    public void delete(Long seaFoodId) {
        Optional<SeaFood> search = findById(seaFoodId);
        seaFoodRepository.delete(search.get());
    }

    @Override
    public SeaFood findByName(String name) {
        return null;
    }

    @Override
    public Optional<SeaFood> save(Optional<SeaFood> newSeaFood) {
        if (newSeaFood.isPresent()){
             seaFoodRepository.save(newSeaFood.get());
             return newSeaFood;
        }
        throw new RuntimeException();
    }

    @Override
    public SeaFood update(Long seafoodId, SeaFood updateSeaFood) {
        if (updateSeaFood != null){
            SeaFood search = findById(seafoodId).orElseThrow(()-> new IndexOutOfBoundsException());
            search.setSeafoodId(updateSeaFood.getSeafoodId());
            search.setItemName(updateSeaFood.getItemName());
            search.setPreparationTime(updateSeaFood.getPreparationTime());
            search.setDescription(updateSeaFood.getDescription());
            search.setPrice(updateSeaFood.getPrice());
            return updateSeaFood;

        }
        throw new RuntimeException();
    }
}
