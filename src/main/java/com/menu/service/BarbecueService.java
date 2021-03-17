package com.menu.service;

import com.menu.exception.ProductAlreadyRegisteredException;

import java.util.List;
import java.util.Optional;

public interface BarbecueService<B> {
    List<B> findAll();
    Optional<B> findById(Long  barbecueId);
    Optional<B> findByName(String name);
    void verifyProductAlreadyRegistered(String itemName) throws ProductAlreadyRegisteredException;
    B save(B newBarbecue) throws ProductAlreadyRegisteredException;
    B update(Long barbecueId ,B updateBarbecue);
    void delete(Long barbecueId);
}
