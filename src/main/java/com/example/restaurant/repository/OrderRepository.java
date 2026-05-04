package com.example.restaurant.repository;

import com.example.restaurant.entity.RestaurantOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<RestaurantOrder, Long> {
}
