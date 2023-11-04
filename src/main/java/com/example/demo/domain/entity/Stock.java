package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private WareHouse warehouse;

    private int maxQuantity;

    private int minQuantity;

    private int currentQuantity;
}
