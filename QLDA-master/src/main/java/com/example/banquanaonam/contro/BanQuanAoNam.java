package com.example.banquanaonam.contro;

import com.example.banquanaonam.Entity.Cart;
import com.example.banquanaonam.Entity.Product;
import com.example.banquanaonam.Entity.User;
import com.example.banquanaonam.service.Cartservice;
import com.example.banquanaonam.service.Productservice;
import com.example.banquanaonam.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class BanQuanAoNam {
    // KHAI BAO SERVICE
    private final Productservice productservice;
    private final Cartservice cartservice;
    private final Userservice userservice;

    public BanQuanAoNam(Productservice productservice, Cartservice cartservice, Userservice userservice) {
        this.productservice = productservice;
        this.cartservice = cartservice;
        this.userservice = userservice;
    }

    // SAN PHAM - PRODUCT
    @GetMapping("/sanpham")
    public String sanpham(Model model) {
        model.addAttribute("product", productservice.getAll());
        return "/QuanAoNam/sanpham/sanpham";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable int id) {
        Product product = productservice.getById(id);
        model.addAttribute("product", product);
        return "/QuanAoNam/sanpham/detail";
    }

    @GetMapping("/timKiem")
    public String timKiem(@RequestParam("name") String name, Model model){
        model.addAttribute("product",productservice.timKiem(name));

        return "/QuanAoNam/sanpham/sanpham";
    }

    // GIO HANG - CART
    @GetMapping("/giohang")
    public String gioHang(Model model){
        model.addAttribute("giohang", cartservice.getAll());
        return "/QuanAoNam/giohang/giohang";
    }

    @GetMapping("/addCart")
    public String addCart(Model model){
        model.addAttribute("giohang", new Cart());
        model.addAttribute("product", productservice.getAll());
        model.addAttribute("user", userservice.getAll());
        return "/QuanAoNam/giohang/formAdd";
    }

    @PostMapping("/add")
    public String addCart(@ModelAttribute("giohang") Cart cart){
        cartservice.save(cart);
        return "/QuanAoNam/giohang/giohang";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        Cart cart = cartservice.getById(id);
        model.addAttribute("giohang", cart);
        return "/QuanAoNam/giohang/formUp";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("giohang") Cart cart){
        cartservice.save(cart);
        return "/QuanAoNam/giohang/giohang";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        cartservice.deleteById(id);
        return "/QuanAoNam/giohang/giohang";
    }

    // User - Người dunng và đăng nhập
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute User user) {
        userservice.register(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        User user = userservice.login(username, password);
        if (user != null) {
            model.addAttribute("user", user);
            return "dashboard";
        } else {
            model.addAttribute("error", "Sai tài khoản hoặc mật khẩu!");
            return "login";
        }
    }
}
