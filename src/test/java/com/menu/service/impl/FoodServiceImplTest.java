package com.menu.service.impl;



import com.menu.document.Food;
import com.menu.dto.FoodDTO;
import com.menu.enums.FoodType;
import com.menu.exception.ProductAlreadyRegisteredException;
import com.menu.exception.ProductNotFoundException;
import com.menu.repository.FoodRepository;

import com.menu.service.FoodService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static java.util.Optional.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class FoodServiceImplTest {


    private static  String ID= "6059411bb0d2ce008af7acf4";
    private static  String ITEMNAME = "maracuja";
    private static  String PREPARATIONTIME = "5 minutos";
    private static  String DESCRIPTION = "suco de maracuja com limao para enfeite";
    private static  double PRICE = 10.0;
    private static FoodType FOODTYPE = FoodType.JUICE;


    @MockBean
    private FoodRepository repository;

    private FoodService service;
    private FoodDTO foodDTO;
    private Food food;

    @BeforeEach
    void setUp() throws Exception {
        service = new FoodServiceImpl(repository);
        foodDTO = new FoodDTO(ID,ITEMNAME,
                PREPARATIONTIME,DESCRIPTION,
                PRICE,FOODTYPE);
        food = service.convertDocumentToDTO(foodDTO);
    }

    @Test
    void findAll() {
        //when
        when(repository.findAll()).thenReturn(Collections.singletonList(food));

        //then
        List<Food> search = service.findAll();
        assertNotNull(search);
        verify(repository,times(1)).findAll();

    }

    @Test
    void  whenSearchingForRepositoryId() throws ProductNotFoundException {


        //when
        when(repository.findById(ID)).thenReturn(ofNullable(food));

        //given
        Food test = service.findById(ID);

        //verify


        //assert
        assertThat(test).isNotNull();
        assertThat(test.getItemName()).isEqualTo(ITEMNAME);
        assertThat(test.getPreparationTime()).isEqualTo(PREPARATIONTIME);
        assertThat(test.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(test.getPrice()).isEqualTo(PRICE);
        assertThat(test.getFoodType()).isEqualTo(FOODTYPE);

    }

    @Test
    void whenSearchingForRepositoryName() throws ProductNotFoundException {
        //when
        when(repository.findByItemName(ITEMNAME)).thenReturn(ofNullable(food));

        //given
        Food test = service.findByName(ITEMNAME);

        //verify
        verify(repository).findByItemName(ITEMNAME);

        //then
        assertThat(test).isNotNull();
        assertThat(test.getItemName()).isEqualTo(ITEMNAME);
        assertThat(test.getPreparationTime()).isEqualTo(PREPARATIONTIME);
        assertThat(test.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(test.getPrice()).isEqualTo(PRICE);
        assertThat(test.getFoodType()).isEqualTo(FOODTYPE);

    }

    @Test
    void whenSavingFoodInTheRepository() throws ProductAlreadyRegisteredException {
        service.saveFood(foodDTO);
        verify(repository).save(food);

    }

    @Test
    void update() throws ProductNotFoundException {
        //when
        when(repository.findById(ID)).thenReturn(ofNullable(food));

        //given
        FoodDTO update = new FoodDTO(ID,"maracuja","5 minutos",
                "suco de maracuja com limao para enfeite",5.0,FoodType.JUICE);

        food = service.update(ID,update);
        //then
        assertNotNull(update);
        assertEquals(food,service.convertDocumentToDTO(update));

    }

    @Test
    void whenYouDeleteAFood() throws ProductNotFoundException {
        //when
        when(repository.findById(ID)).thenReturn(ofNullable(food));
        doNothing().when(repository).deleteById(ID);

        //then
        service.delete(ID);
        verify(repository,times(1)).findById(ID);
        verify(repository,times(1)).deleteById(ID);
    }


    @Test
    void whenFoodDoesNotExist() {
        assertThrows(ProductNotFoundException.class,() -> service.findById(ID));
    }

    @Test
    void shouldNotSaveTwoFoodsWithTheSameName() {
        when(repository.findByItemName(ITEMNAME)).thenReturn(ofNullable(food));
        ProductAlreadyRegisteredException exception = assertThrows(ProductAlreadyRegisteredException.class,
                () -> service.saveFood(foodDTO));
        assertEquals("O produto ja esta cadastrado ",exception.getMessage());
    }

    @Test
    void whenListFoodIsCalledThenReturnAnEmptyListOfFoods() {
        when(repository.findAll()).thenReturn(Collections.EMPTY_LIST);
        List<Food> search = service .findAll();
        assertEquals(search,Collections.EMPTY_LIST);
    }
}