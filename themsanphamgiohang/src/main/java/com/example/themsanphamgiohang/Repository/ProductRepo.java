package com.example.themsanphamgiohang.Repository;


import com.example.themsanphamgiohang.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
