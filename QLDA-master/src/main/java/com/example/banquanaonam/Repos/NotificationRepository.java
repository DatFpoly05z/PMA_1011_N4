package com.example.banquanaonam.Repos;

import com.example.banquanaonam.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}