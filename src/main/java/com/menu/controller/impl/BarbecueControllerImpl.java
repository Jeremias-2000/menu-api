package com.menu.controller.impl;

import com.menu.controller.BarbecueRequests;

import com.menu.dto.BarbecueDTO;
import com.menu.exception.ProductAlreadyRegisteredException;
import com.menu.exception.ProductNotFoundException;
import com.menu.service.impl.BarbecueServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@Slf4j
@RestController
@RequestMapping("/api/v1/menu/barbecue")

public class BarbecueControllerImpl implements BarbecueRequests {
    @Autowired
    private final BarbecueServiceImpl barbecueService;

    public BarbecueControllerImpl(BarbecueServiceImpl barbecueService) {
        this.barbecueService = barbecueService;
    }

    @Override
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(barbecueService.findAll());
    }

    @Override
    public ResponseEntity<?> findBarbecueById(Long barbecueId) throws ProductNotFoundException {
        return ResponseEntity.ok(barbecueService
                .findById(barbecueId));
    }

    @Override
    public ResponseEntity<?> save(BarbecueDTO barbecueDTO)
            throws ProductAlreadyRegisteredException {
        return new ResponseEntity<>(barbecueService.save(barbecueDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateBarbecueById(Long barbecueId, BarbecueDTO barbecueDTO)
            throws ProductNotFoundException {

        return ResponseEntity.ok(barbecueService.update(barbecueId, barbecueDTO));

    }

    @Override
    public ResponseEntity<?> deleteBarbecueById(Long barbecueId)
            throws ProductNotFoundException {
        barbecueService.delete(barbecueId);
        return ResponseEntity.ok().build();
    }
}
