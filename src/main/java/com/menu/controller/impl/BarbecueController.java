package com.menu.controller.impl;

import com.menu.controller.BarbecueRequests;
import com.menu.document.Barbecue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api v1 menu barbecue")
public class BarbecueController implements BarbecueRequests {
    @Override
    public ResponseEntity<?> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> findBarbecueById(Barbecue barbecueId) {
        return null;
    }

    @Override
    public ResponseEntity<?> save(Barbecue barbecue) {
        return null;
    }
}
