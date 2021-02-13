package com.menu.service.impl;

import com.menu.document.Barbecue;
import com.menu.repository.BarbecueRepository;
import com.menu.service.BarbecueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbecueServiceImpl implements BarbecueService<Barbecue>
{
    @Autowired
    private BarbecueRepository barbecueRepository;

    @Override
    public List<Barbecue> findAll() {
        return barbecueRepository.findAll();
    }

    @Override
    public Barbecue findById(Long barbecueId) {
        return barbecueRepository.findById(barbecueId)
                .orElseThrow(()->new RuntimeException());
    }

    @Override
    public Barbecue findByName(String name) {
        return null;
    }

    @Override
    public Barbecue save(Barbecue newBarbecue) {
        return barbecueRepository.save(newBarbecue);
    }

    @Override
    public Barbecue update(Long barbecueId, Barbecue updateBarbecue) {
        Barbecue search = barbecueRepository.findById(barbecueId)
                .orElseThrow(()->new RuntimeException());
        search.setBarbecueId(updateBarbecue.getBarbecueId());
        search.setItemName(updateBarbecue.getItemName());
        search.setPreparationTime(updateBarbecue.getPreparationTime());
        search.setDescription(updateBarbecue.getDescription());
        search.setPrice(updateBarbecue.getPrice());
        return search;
    }

    @Override
    public void delete(Long barbecueId) {
       Barbecue search =  barbecueRepository.findById(barbecueId)
                .orElseThrow(()->new RuntimeException());
       barbecueRepository.delete(search);
    }
}
