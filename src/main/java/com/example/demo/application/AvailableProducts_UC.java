package com.example.demo.application;

import com.example.demo.domain.service.StockService;
import com.example.demo.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvailableProducts_UC
{
    @Autowired
    private StockService stockService;

    public AvailableProducts_UC(StockService stockService) {
        this.stockService = stockService;
    }

    public List<Product> run() {
        return stockService.availableProducts();
    }
}
