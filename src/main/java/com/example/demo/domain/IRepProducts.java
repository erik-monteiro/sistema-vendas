package com.example.demo.domain;

import com.example.demo.domain.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IRepProducts
{
    void save(Product p);
    List<Product> all();

    Product getById(Long productId);
}

