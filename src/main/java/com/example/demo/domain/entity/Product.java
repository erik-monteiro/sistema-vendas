package com.example.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Stock> stocks;

}
