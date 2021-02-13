package com.menu.service.impl;

import com.menu.document.Juice;
import com.menu.repository.JuiceRepository;
import com.menu.service.JuiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuiceServiceImpl implements JuiceService<Juice> {
   @Autowired
   private JuiceRepository juiceRepository;

    @Override
    public List<Juice> findAll() {
        return null;
    }

    @Override
    public Juice findById(Long juiceId) {
        return null;
    }

    @Override
    public Juice findByName(String name) {
        return null;
    }

    @Override
    public Juice save(Juice newJuice) {
        return null;
    }

    @Override
    public Juice updateJuice(Long JuiceId, Juice updateJuice) {
        return null;
    }

    @Override
    public void deleteJuice(Long JuiceId) {

    }
}
