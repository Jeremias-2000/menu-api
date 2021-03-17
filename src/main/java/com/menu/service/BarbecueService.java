package com.menu.service;

import java.util.List;
import java.util.Optional;

public interface BarbecueService<B> {
    List<B> findAll();
    Optional<B> findById(Long  barbecueId);
    B findByName(String name);
    Optional<B> save(Optional<B> newBarbecue);
    B update(Long barbecueId ,B updateBarbecue);
    void delete(Long barbecueId);
}
