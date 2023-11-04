package com.example.demo.persistence;

import com.example.demo.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepProductsJPA extends CrudRepository<Product, Long>
{
    List<Product> findAll();
}
