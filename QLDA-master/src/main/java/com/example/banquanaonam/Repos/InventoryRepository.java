package com.example.banquanaonam.Repos;

import com.example.banquanaonam.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}