package com.menu.service;

import com.menu.exception.ProductAlreadyRegisteredException;
import com.menu.exception.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

public interface BarbecueService<B> {
    List<B> findAll();
    B findById(Long  barbecueId) throws ProductNotFoundException;
    Optional<B> findByName(String name);
    void verifyProductAlreadyRegistered(String itemName) throws ProductAlreadyRegisteredException;
    B verifyIfExists(Long barbecueId) throws ProductNotFoundException;
    B save(B newBarbecue) throws ProductAlreadyRegisteredException;
    B update(Long barbecueId ,B updateBarbecue) throws ProductNotFoundException;
    void delete(Long barbecueId) throws ProductNotFoundException;
}
