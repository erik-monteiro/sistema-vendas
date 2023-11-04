package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "product")
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "product_id")
public class Product
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    private String description;

    private double price;

}
