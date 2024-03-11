package com.tp.bddd.repository;

import com.tp.bddd.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;

public interface OrderRepository extends MongoRepository<Order, String> {
    Iterable<Order> findByDateBetween(LocalDate startDate, LocalDate endDate);

    Iterable<Order> findByClientId(String clientId);

    Iterable<Order> findBySellerId(String sellerId);

    @Query("{$or: [{ 'materials.serialNumber': { $regex: ?0, $options: 'i' } }, { 'materials.brand': { $regex: ?0, $options: 'i' } }, { 'materials.model': { $regex: ?0, $options: 'i' } }, { 'materials.type': { $regex: ?0, $options: 'i' } }]}")
    Iterable<Order> findByMaterialQuery(String materialQuery);
}
