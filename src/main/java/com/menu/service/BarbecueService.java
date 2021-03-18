package com.menu.service;

import com.menu.document.Barbecue;
import com.menu.exception.ProductAlreadyRegisteredException;
import com.menu.exception.ProductNotFoundException;

import java.util.List;

public interface BarbecueService<B> {
    List<Barbecue> findAll();
    Barbecue findById(Long  barbecueId) throws ProductNotFoundException;
    Barbecue findByName(String name) throws ProductNotFoundException;
    void verifyProductAlreadyRegistered(String itemName) throws ProductAlreadyRegisteredException;

    Barbecue save(B barbecueDTO) throws ProductAlreadyRegisteredException;
    Barbecue update(Long barbecueId , B barbecueDTO) throws ProductNotFoundException, ProductAlreadyRegisteredException;
    void delete(Long barbecueId) throws ProductNotFoundException;
}
