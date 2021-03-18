package com.menu.service.impl;

import com.menu.document.Barbecue;

import com.menu.dto.BarbecueDTO;
import com.menu.exception.ProductAlreadyRegisteredException;
import com.menu.exception.ProductNotFoundException;


import com.menu.repository.BarbecueRepository;
import com.menu.service.BarbecueService;
import lombok.AllArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor(onConstructor = @ __(@Autowired))
public class BarbecueServiceImpl implements BarbecueService<BarbecueDTO>
{

    private final BarbecueRepository barbecueRepository;


    @Override
    public List<Barbecue> findAll() {
        return barbecueRepository.findAll();
    }

    @Override
    public Barbecue findById(String barbecueId) throws ProductNotFoundException {
      return barbecueRepository.findById(barbecueId)
              .orElseThrow(()->
                      new ProductNotFoundException(barbecueId) );

    }



    @Override
    public Barbecue findByName(String name) throws ProductNotFoundException {
        Barbecue search = barbecueRepository
                .findByItemName(name).orElseThrow(()-> new ProductNotFoundException(name));
        return search;
    }



    @Override
    public Barbecue save(BarbecueDTO barbecueDTO) throws ProductAlreadyRegisteredException {
        if (barbecueDTO != null){
            verifyProductAlreadyRegistered(barbecueDTO.getItemName());
            Barbecue barbecue = convertDTO(barbecueDTO);

            return barbecueRepository.save(barbecue);
        }
        return null;

    }

    @Override
    public Barbecue update(String barbecueId, BarbecueDTO barbecueDTO) throws ProductNotFoundException {

        if(barbecueDTO != null){
            Barbecue search = findById(barbecueId);
            Barbecue barbecue = convertDTO(barbecueDTO);
            search.setItemName(barbecue.getItemName());
            search.setPreparationTime(barbecue.getPreparationTime());
            search.setDescription(barbecueDTO.getDescription());
            search.setPrice(barbecue.getPrice());
            return search;
       }
       throw new NullPointerException();
    }



    @Override
    public void verifyProductAlreadyRegistered(String itemName) throws ProductAlreadyRegisteredException {
        Optional<Barbecue> search = barbecueRepository.findByItemName(itemName);
        if (search.isPresent()){
            throw new ProductAlreadyRegisteredException(itemName);
        }
    }

    @Override
    public void delete(String barbecueId) throws ProductNotFoundException {
       findById(barbecueId);
       barbecueRepository.deleteById(barbecueId);
        System.out.println("Produto deletado !");
    }

    private Barbecue convertDTO(BarbecueDTO barbecueDTO){
       return Barbecue.builder()
               .itemName(barbecueDTO.getItemName())
               .preparationTime(barbecueDTO.getPreparationTime())
               .description(barbecueDTO.getDescription())
               .price(barbecueDTO.getPrice()).build();
    }


}
