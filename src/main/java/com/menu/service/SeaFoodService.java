package com.menu.service;

import java.util.List;

public interface SeaFoodService<S> {
    List<S> findAll();
    S findById(Long  seafoodId);
    S findByName(String name);
    S save(S newSeaFood);
    S update(Long seafoodId ,S updateSeaFood);
    void delete(Long SeaFoodId);
}
