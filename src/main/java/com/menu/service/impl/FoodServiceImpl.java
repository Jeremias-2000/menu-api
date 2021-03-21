package com.menu.service.impl;

import com.menu.document.Food;
import com.menu.dto.FoodDTO;
import com.menu.exception.ProductAlreadyRegisteredException;
import com.menu.exception.ProductNotFoundException;
import com.menu.repository.FoodRepository;
import com.menu.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService<FoodDTO>{
   @Autowired
   private FoodRepository repository;

    @Override
    public List<Food> findAll() {
        return repository.findAll();
    }

    @Override
    public Food findById(String id) throws ProductNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Food findByName(String itemName) throws ProductNotFoundException {

        Food search = repository.findByItemName(itemName)
                .orElseThrow(()-> new ProductNotFoundException(itemName));
        return search;

    }

    @Override
    public Food saveFood(FoodDTO foodDTO) throws ProductAlreadyRegisteredException {
        if (foodDTO != null){
            verifyFoodAlreadyRegistered(foodDTO.getItemName());
            Food food = convertDocumentToDTO(foodDTO);
            return repository.save(food);
        }
        return  null;
    }

    @Override
    public Food update(String id,FoodDTO foodDTO) throws ProductNotFoundException {
        Food search = findById(id);
        if (foodDTO != null){
            Food updateFood = convertDocumentToDTO(foodDTO);
            search.setItemName(updateFood.getItemName());
            search.setPreparationTime(updateFood.getPreparationTime());
            search.setDescription(updateFood.getDescription());
            search.setPrice(updateFood.getPrice());
            search.setFoodType(updateFood.getFoodType());

            return search;
        }
      return null;
    }

    @Override
    public void delete(String id) throws ProductNotFoundException {
        findById(id);
        repository.deleteById(id);

    }

    @Override
    public void verifyFoodAlreadyRegistered(String name) throws ProductAlreadyRegisteredException {
        Optional<Food> search = repository.findByItemName(name);
        if (search.isPresent()){
            throw  new ProductAlreadyRegisteredException(name);
        }
    }

    @Override
    public Food convertDocumentToDTO(FoodDTO foodDTO) {
        return Food.builder()
                .id(foodDTO.getId())
                .itemName(foodDTO.getItemName())
                .preparationTime(foodDTO.getPreparationTime())
                .description(foodDTO.getDescription())
                .price(foodDTO.getPrice())
                .foodType(foodDTO.getFoodType()).build();
    }
}
