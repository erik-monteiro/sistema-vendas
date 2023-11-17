package com.example.demo.domain;

import java.util.List;

import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Order;

public interface IRepOrders
{
    Order getById(Long orderId);

    List<Order> findByClientName(String clientName);

}
