package com.example.demo.infra;

import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Order;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IRepOrdersJPA  extends CrudRepository<Order, Long>
        {
                List<Order> findAll();
}
