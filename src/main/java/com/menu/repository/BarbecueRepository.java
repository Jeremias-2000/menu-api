package com.menu.repository;

import com.menu.document.Barbecue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarbecueRepository extends MongoRepository<Barbecue,Long> {
}
