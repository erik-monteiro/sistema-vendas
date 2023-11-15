package com.example.demo.domain;

import com.example.demo.domain.entity.Order;

public interface IRepOrders
{
    Order getById(Long orderId);
}
