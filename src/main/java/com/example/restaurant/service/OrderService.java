package com.example.restaurant.service;

import com.example.restaurant.entity.RestaurantOrder;
import com.example.restaurant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<RestaurantOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public RestaurantOrder placeOrder(RestaurantOrder order) {
        order.setStatus("RECEIVED");
        return orderRepository.save(order);
    }
}
