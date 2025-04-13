package com.example.banquanaonam.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Reports")
public class Report {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "report_date", nullable = false)
    private LocalDate reportDate;

    @ColumnDefault("0")
    @Column(name = "total_orders", nullable = false)
    private Integer totalOrders;

    @ColumnDefault("0")
    @Column(name = "total_revenue", nullable = false, precision = 15, scale = 2)
    private BigDecimal totalRevenue;

}