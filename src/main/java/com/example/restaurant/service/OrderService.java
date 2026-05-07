package com.example.restaurant.service;

import com.example.restaurant.entity.RestaurantOrder;

import java.util.List;

public interface OrderService {
    List<RestaurantOrder> getAllOrders();

    RestaurantOrder placeOrder(RestaurantOrder order);
}
