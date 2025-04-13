package com.example.banquanaonam.service;

import com.example.banquanaonam.Entity.Product;
import com.example.banquanaonam.Repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Productservice {

    private final ProductRepository repository;

    public Productservice(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product getById(int id) {
        return repository.findById(id).get();
    }

    public List<Product> timKiem(String name) {
        return repository.timKiem("%"+name+"%");
    }
}
