package com.menu.repository;

import com.menu.document.Food;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodRepository extends MongoRepository<Food,String> {
    Optional<Food> findByItemName(String itemName);
}
