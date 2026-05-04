package com.example.restaurant.service;

import com.example.restaurant.entity.RestaurantOrder;
import com.example.restaurant.BadRequestException;
import com.example.restaurant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<RestaurantOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public RestaurantOrder placeOrder(RestaurantOrder order) {
        validateOrder(order);
        order.setStatus("RECEIVED");
        return orderRepository.save(order);
    }

    private void validateOrder(RestaurantOrder order) {
        if (order == null) {
            throw new BadRequestException();
        }
        String mealName = order.getMealName();
        if (mealName == null) {
            throw new BadRequestException("Meal name is required");
        }
        mealName = mealName.trim();
        if (mealName.isEmpty()) {
            throw new BadRequestException("Meal name is required");
        }
        if (mealName.length() > 200) {
            throw new BadRequestException("Meal name must be at most 200 characters");
        }
        order.setMealName(mealName);
    }
}
