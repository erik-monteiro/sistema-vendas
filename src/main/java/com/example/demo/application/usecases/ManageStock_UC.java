package com.example.demo.application.usecases;

import com.example.demo.domain.IRepProducts;
import com.example.demo.domain.IRepStocks;
import com.example.demo.domain.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageStock_UC
{
    private IRepStocks stocksRep;

    @Autowired
    public ManageStock_UC(IRepStocks stocksRep) {
        this.stocksRep = stocksRep;
    }

    public List<Stock> availableStocks() {
        return stocksRep.all();
    }

    public void setQuantity(long id, int quantity){
        Stock stock = stocksRep.findByStock(id);
        if (stock != null) {
            stock.setCurrentQuantity(quantity);
            stocksRep.save(stock);
        }
    }
}
