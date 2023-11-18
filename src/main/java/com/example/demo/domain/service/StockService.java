package com.example.demo.domain.service;

import com.example.demo.domain.IRepProducts;
import com.example.demo.domain.IRepStocks;
import com.example.demo.domain.entity.Product;
import com.example.demo.domain.entity.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService
{
    private IRepStocks stocksRep;
    private IRepProducts iRepProducts;

    @Autowired
    public StockService(IRepStocks stocksRep, IRepProducts iRepProducts) {
        this.stocksRep = stocksRep;
        this.iRepProducts = iRepProducts;
    }

    public List<Stock> availableStocks() {
        return stocksRep.all();
    }

    public List<Product> availableProducts() {
        return iRepProducts.all();
    }

}
