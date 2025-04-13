package com.example.banquanaonam;

import com.example.banquanaonam.Entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BanQuanAoNamApplication {

    public static void main(String[] args) {
        SpringApplication.run(BanQuanAoNamApplication.class, args);

    }

}
