package com.example.banquanaonam.Repos;

import com.example.banquanaonam.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}