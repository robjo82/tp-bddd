package com.tp.bddd.repository;

import com.tp.bddd.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepository extends MongoRepository<Group, String> {
}
