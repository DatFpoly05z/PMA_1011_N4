package com.example.themsanphamgiohang.Controller;

import com.example.themsanphamgiohang.Entity.Product;
import com.example.themsanphamgiohang.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/san-pham")
public class ProductController {
    @Autowired
    ProductRepo productRepo;

    @GetMapping("/hien-thi")
    public List<Product> hienThi(){
        return productRepo.findAll();
    }
    @PostMapping("/them")
    public String them(@RequestBody Product product){
        productRepo.save(product);
        return "ok";
    }
}
