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

    @Autowired
    public StockService(IRepStocks stocksRep) {
        this.stocksRep = stocksRep;
    }

    public List<Stock> availableStocks() {
        return stocksRep.all();
    }

    public void setQuantity(long id, int quantity){
        Stock stock = stocksRep.findByStock(id);
        if (stock != null) {
            stock.setCurrentQuantity(quantity);
            stocksRep.save(stock); // Salva a alteração no estoque
        }
    }

    public List<Product> availableProducts() {
        return null;
    }

}
