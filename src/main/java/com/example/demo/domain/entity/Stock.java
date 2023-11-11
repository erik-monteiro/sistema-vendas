package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "stock")
@Table(name = "stock")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "stock_id")
public class Stock
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stock_id;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private WareHouse warehouse;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int maxQuantity;

    private int minQuantity;

    private int currentQuantity;
}
