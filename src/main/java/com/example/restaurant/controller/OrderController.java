package com.example.restaurant.controller;

import com.example.restaurant.entity.RestaurantOrder;
import com.example.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// TODO 1: Add the correct annotations to make this class a REST Controller.


public class OrderController {

    // TODO 2: Inject the OrderService into this controller.

   
    private OrderService orderService;

    // TODO 3: Create two endpoints to handle HTTP requests:
    // A. Write a method with @GetMapping that calls orderService.getAllOrders() and returns the list.
    // B. Write a method with @PostMapping that receives a @RequestBody RestaurantOrder, saves it using orderService.placeOrder(order), and returns it.


}
