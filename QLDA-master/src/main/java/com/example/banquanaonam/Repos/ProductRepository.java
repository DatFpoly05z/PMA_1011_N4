package com.example.banquanaonam.Repos;

import com.example.banquanaonam.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("from  Product where name like ?1")
    public List<Product> timKiem(String name);

}