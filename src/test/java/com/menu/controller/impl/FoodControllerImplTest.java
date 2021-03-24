package com.menu.controller.impl;

import com.menu.dto.FoodDTO;
import com.menu.service.impl.FoodServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.Valid;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FoodControllerImplTest {

    @Mock
    private FoodServiceImpl service;
    @InjectMocks
    private FoodControllerImpl underTest;

    @Test
    void findAll() {
    }

    @Test
    void findBarbecueById() {
    }

    @Test
    void findBarbecueByName() {
    }

    @Test
    void save() {
    }

    @Test
    void updateBarbecueById() {
    }

    @Test
    void deleteBarbecueById() {
    }




}