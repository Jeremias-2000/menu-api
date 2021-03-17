package com.menu.repository;

import com.menu.document.Juice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuiceRepository extends MongoRepository<Juice,Long> {

}
