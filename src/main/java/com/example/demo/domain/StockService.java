package com.example.demo.domain;

import com.example.demo.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService
{
    private IRepProducts productsRep;

    @Autowired
    public StockService(IRepProducts iRepProducts) {
        this.productsRep = iRepProducts;
    }

    public List<Product> availableProducts() {
        return productsRep.all();
    }

}
