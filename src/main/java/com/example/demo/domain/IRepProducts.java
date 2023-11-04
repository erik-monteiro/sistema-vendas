package com.example.demo.domain;

import com.example.demo.domain.entity.Product;

import java.util.List;

public interface IRepProducts
{
    void save(Product p);
    List<Product> all();
}
