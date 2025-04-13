package com.example.banquanaonam.Repos;

import com.example.banquanaonam.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}