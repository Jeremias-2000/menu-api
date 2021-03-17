package com.menu.repository;

import com.menu.document.SeaFood;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeaFoodRepository extends MongoRepository<SeaFood,Long> {
}
