package com.menu.service;

import java.util.List;

public interface BarbecueService<B> {
    List<B> findAll();
    B findById(Long  barbecueId);
    B findByName(String name);
    B save(B newBarbecue);
    B update(Long barbecueId ,B updateBarbecue);
    void delete(Long barbecueId);
}
