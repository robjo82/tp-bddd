package com.tp.bddd.repository;

import com.tp.bddd.model.Member;
import com.tp.bddd.model.enums.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MemberRepository extends MongoRepository<Member, String> {
    List<Member> findByStatus(Status status);
}
