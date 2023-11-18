package com.example.demo.domain;

import com.example.demo.domain.entity.Budget;
//import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Stock;

import java.util.List;
import java.util.Optional;

public interface IRepStocks
{
    void save(Stock stock);

    List<Stock> all();

    Stock findByStock(long id);

    Stock findByProductId(long productId);

    void decreaseProductQuantity(int quantity, long productId);

}