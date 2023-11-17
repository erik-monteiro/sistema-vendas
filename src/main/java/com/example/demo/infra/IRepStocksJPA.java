package com.example.demo.infra;

import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Stock;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepStocksJPA extends CrudRepository<Stock, Long>
{
    List<Stock> findAll();

}
