package com.example.duanbanqaotest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductsService {
        private List<Products> products = new ArrayList<>();

        public ProductsService() {
            products.add(new Products(1, "Laptop Dell XPS 13", "Máy Xịn số 1", 1.55f, 10, LocalDateTime.now()));
        }

        public Products findById(int id) { // Đổi id từ String -> int
            return products.stream()
                    .filter(product -> product.getId() == id) // So sánh trực tiếp số nguyên
                    .findFirst()
                    .orElse(null);
        }

        public void update(Products product) {
            if (product == null) {
                throw new IllegalArgumentException("Sản phẩm không hợp lệ");
            }

            Products existingProduct = findById(product.getId()); // Không cần kiểm tra null vì id là int
            if (existingProduct == null) {
                throw new IllegalArgumentException("Sản phẩm không tồn tại");
            }

            if (product.getName() == null || product.getName().trim().isEmpty() || product.getPrice() <= 0) {
                throw new IllegalArgumentException("Dữ liệu sản phẩm không hợp lệ");
            }

            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());

            if (product.getDescription() != null) {
                existingProduct.setDescription(product.getDescription());
            }

            if (product.getPrice() >= 0) {
                existingProduct.setPrice(product.getPrice());
            }
        }
    }
