package com.menu.service.impl;

import com.menu.document.Pasta;
import com.menu.repository.PastaRepository;
import com.menu.service.PastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PastaServiceImpl implements PastaService<Pasta> {
    @Autowired
    private PastaRepository pastaRepository;

    @Override
    public List<Pasta> findAll(){
        return pastaRepository.findAll();
    }
    @Override
    public Pasta save(Pasta newPasta) {
        return pastaRepository.save(newPasta);
    }

    @Override
    public Pasta findById(Long pastaId) {
        return null;
    }

    @Override
    public Pasta findByName(String name) {
        return null;
    }

    @Override
    public Pasta update(Long pastaId, Pasta updatePasta) {
        return null;
    }

    @Override
    public void deletePasta(Long pastaId) {

    }



}
