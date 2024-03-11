package com.tp.bddd.controller;

import com.tp.bddd.model.Order;
import com.tp.bddd.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Tag(name = "Tax", description = "Operations on orders related to taxes")
public class TaxController {
    private final OrderService orderService;

    @GetMapping("/search-by-date")
    public ResponseEntity<Iterable<Order>> getOrdersByDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return ResponseEntity.ok(orderService.getOrdersByDate(startDate, endDate));
    }

    @GetMapping("/search-by-client")
    public ResponseEntity<Iterable<Order>> getOrdersByClient(@RequestParam String clientId) {
        return ResponseEntity.ok(orderService.getOrdersByClient(clientId));
    }

    @GetMapping("/search-by-seller")
    public ResponseEntity<Iterable<Order>> getOrdersBySeller(@RequestParam String sellerId) {
        return ResponseEntity.ok(orderService.getOrdersBySeller(sellerId));
    }

    @GetMapping("/search-by-material")
    public ResponseEntity<Iterable<Order>> getOrdersByMaterial(@RequestParam String materialQuery) {
        return ResponseEntity.ok(orderService.getOrdersByMaterial(materialQuery));
    }
}
