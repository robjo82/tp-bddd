package com.tp.bddd.controller;

import com.tp.bddd.model.Order;
import com.tp.bddd.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Tag(name = "Order", description = "Managing orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.saveOrder(order));
    }

    @GetMapping
    public ResponseEntity<Iterable<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
