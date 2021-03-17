package com.menu.repository;

import com.menu.document.Drink;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends MongoRepository<Drink,Long> {

}
