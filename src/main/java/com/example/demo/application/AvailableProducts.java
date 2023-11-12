package com.example.demo.application;

import com.example.demo.domain.StockService;
import com.example.demo.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvailableProducts
{
    @Autowired
    private StockService stockService;

    public AvailableProducts(StockService stockService) {
        this.stockService = stockService;
    }

    public List<Product> run() {
        return stockService.availableProducts();
    }
}
