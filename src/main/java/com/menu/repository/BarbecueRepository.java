package com.menu.repository;

import com.menu.document.Barbecue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BarbecueRepository extends MongoRepository<Barbecue,Long> {
    Optional<Barbecue> findByItemName(String itemName);
}
