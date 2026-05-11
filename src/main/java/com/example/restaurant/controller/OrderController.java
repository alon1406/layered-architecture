package com.example.restaurant.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.restaurant.service.OrderService;

// TODO 1: Add the correct annotations to make this class a REST Controller.

@RequestMapping("/api/orders") 
public class OrderController {

    // TODO 2: Inject the OrderService into this controller.

   
    private OrderService orderService;

    // TODO 3: Create two endpoints to handle HTTP requests:
    // A. Write a method with @GetMapping that calls orderService.getAllOrders() and returns the list.
    // B. Write a method with @PostMapping that receives a @RequestBody RestaurantOrder, saves it using orderService.placeOrder(order), and returns it.

  


}