package com.menu.repository;

import com.menu.document.Pasta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastaRepository extends MongoRepository<Pasta,Long> {
}
