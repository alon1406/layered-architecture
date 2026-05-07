package com.example.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.entity.RestaurantOrder;
import com.example.restaurant.service.OrderService;

// TODO 1: Add the correct annotations to make this class a REST Controller.

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    // TODO 2: Inject the OrderService into this controller.

    @Autowired
    private OrderService orderService;

    // TODO 3: Create two endpoints to handle HTTP requests:
    // A. Write a method with @GetMapping that calls orderService.getAllOrders() and returns the list.
    // B. Write a method with @PostMapping that receives a @RequestBody RestaurantOrder, saves it using orderService.placeOrder(order), and returns it.

    @GetMapping
    public ResponseEntity<List<RestaurantOrder>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PostMapping
    public ResponseEntity<RestaurantOrder> placeOrder(@RequestBody RestaurantOrder order) {
        RestaurantOrder saved = orderService.placeOrder(order);
        return ResponseEntity.status(201).body(saved);
    }
}