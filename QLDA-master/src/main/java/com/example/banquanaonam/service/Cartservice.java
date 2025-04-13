package com.example.banquanaonam.service;

import com.example.banquanaonam.Entity.Cart;
import com.example.banquanaonam.Repos.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Cartservice {
    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    public Cart getById(int id) {
        return cartRepository.findById(id).get();
    }

    public void deleteById(int id) {
        cartRepository.deleteById(id);
    }
}
