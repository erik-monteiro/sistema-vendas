package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "order")
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "order_id")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    private String clientName;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Budget budget;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Item> items;
}

