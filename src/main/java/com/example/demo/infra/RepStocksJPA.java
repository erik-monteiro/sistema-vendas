package com.example.demo.infra;

import com.example.demo.domain.IRepStocks;
import com.example.demo.domain.entity.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Primary
public class RepStocksJPA implements IRepStocks
{
    private IRepStocksJPA iRepStocksJPA;

    @Autowired
    public RepStocksJPA(IRepStocksJPA iRepStocksJPA) {
        this.iRepStocksJPA = iRepStocksJPA;
    }

    @Override
    public void save(Stock stock) {
        this.iRepStocksJPA.save(stock);
    }

    @Override
    public List<Stock> all() {
        return this.iRepStocksJPA.findAll();
    }

    @Override
    public Stock findByStock(long id) {
        Optional<Stock> foundStock = iRepStocksJPA.findAll()
                .stream()
                .filter(s -> s.getStock_id() == id)
                .findFirst();

        return foundStock.orElse(null);
    }

    @Override
    public Stock findByProductId(long productId) {
        Optional<Stock> foundStock = iRepStocksJPA.findAll()
                .stream()
                .filter(s -> s.getProduct().getId() == productId)
                .findFirst();

        return foundStock.orElse(null);
    }

    @Override
    public void decreaseProductQuantity(int quantity, long productId) {
        Stock stock = findByProductId(productId);

        if (stock != null) {
            int currentQuantity = stock.getCurrentQuantity();
            int newQuantity = Math.max(0, currentQuantity - quantity);
            stock.setCurrentQuantity(newQuantity);
            save(stock);
        }
    }


}
