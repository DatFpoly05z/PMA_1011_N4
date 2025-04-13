package com.example.banquanaonam.Repos;

import com.example.banquanaonam.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}