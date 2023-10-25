package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "product")
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "product_id")
public class Product
{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;

    private String description;

    private double price;
}
