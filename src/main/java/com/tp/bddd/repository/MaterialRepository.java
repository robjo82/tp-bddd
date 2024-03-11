package com.tp.bddd.repository;

import com.tp.bddd.model.Material;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaterialRepository extends MongoRepository<Material, String> {
}
