package com.menu.service;

import java.util.List;
import java.util.Optional;

public interface SeaFoodService<S> {
    List<S> findAll();
    Optional<S> findById(Long  seafoodId);
    S findByName(String name);
    Optional<S> save(Optional<S> newSeaFood);
    S update(Long seafoodId ,S updateSeaFood);
    void delete(Long SeaFoodId);
}
