package com.example.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "product")
@Table(name = "product")
@EqualsAndHashCode(of = "product_id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    private String description;

    private double price;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Stock> stocks;

    public double getPrice() {
        return price;
    }

    public Long getId() {
        return product_id;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public String getDescription() {
        return description;
    }
}
