package com.menu.repository;

import com.menu.document.Food;
import com.menu.dto.FoodDTO;
import com.menu.enums.FoodType;
import com.menu.service.FoodService;
import com.menu.service.impl.FoodServiceImpl;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static java.util.Optional.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@DataMongoTest
@AllArgsConstructor(onConstructor = @ __(@Autowired))
class FoodRepositoryTest {


    private FoodRepository repository;


    @Test
    void findByItemName() {
        Food food =new Food("6059411bb0d2ce008af7acf4","maracuja","5 minutos",
                "suco de maracuja com limao para enfeite",5.0,1,FoodType.JUICE);
        repository.save(food);
        Optional<Food> search = repository.findByItemName("maracuja");
        assertNotNull(search);
    }
}