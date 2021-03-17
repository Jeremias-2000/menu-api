package com.menu.service.impl;

import com.menu.document.Barbecue;
import com.menu.exception.ProductAlreadyRegisteredException;
import com.menu.repository.BarbecueRepository;
import com.menu.service.BarbecueService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;

@Service
public class BarbecueServiceImpl implements BarbecueService<Barbecue>
{
    @Autowired
    private BarbecueRepository barbecueRepository;

    public BarbecueServiceImpl(BarbecueRepository barbecueRepository) {
        this.barbecueRepository = barbecueRepository;
    }

    @Override
    public List<Barbecue> findAll() {
        return barbecueRepository.findAll();
    }

    @Override
    public Optional<Barbecue> findById(Long barbecueId) {
        return ofNullable(barbecueRepository.findById(barbecueId)
                .orElseThrow(()-> new RuntimeException()));
    }

    @Override
    public Optional<Barbecue> findByName(String name) {
        return barbecueRepository.findByItemName(name);
    }



    @Override
    public Barbecue save(Barbecue newBarbecue) throws ProductAlreadyRegisteredException {
        if (newBarbecue != null){
            verifyProductAlreadyRegistered(newBarbecue.getItemName());
            return barbecueRepository.save(newBarbecue);
        }
        return null;

    }

    @Override
    public Barbecue update(Long barbecueId, Barbecue updateBarbecue) {
        Barbecue search = findById(barbecueId)
                .orElseThrow(()-> new RuntimeException());
        search.setBarbecueId(updateBarbecue.getBarbecueId());
        search.setItemName(updateBarbecue.getItemName());
        search.setPreparationTime(updateBarbecue.getPreparationTime());
        search.setDescription(updateBarbecue.getDescription());
        search.setPrice(updateBarbecue.getPrice());
        System.out.println("Produto atualizado");
        return search;
    }

    @Override
    public void verifyProductAlreadyRegistered(String itemName) throws ProductAlreadyRegisteredException {
        Optional<Barbecue> search = barbecueRepository.findByItemName(itemName);
        if (search.isPresent()){
            throw new ProductAlreadyRegisteredException(itemName);
        }
    }

    @Override
    public void delete(Long barbecueId) {
       barbecueRepository.delete(findById(barbecueId)
               .orElseThrow(()-> new RuntimeException()));
        System.out.println("Produto deletado !");
    }
}
