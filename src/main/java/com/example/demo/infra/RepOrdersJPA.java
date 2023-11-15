package com.example.demo.infra;

import com.example.demo.domain.IRepOrders;
import com.example.demo.domain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class RepOrdersJPA implements IRepOrders
{
    private IRepOrdersJPA orderRepository;

    @Autowired
    public RepOrdersJPA(IRepOrdersJPA iRepOrdersJPA) {
        this.orderRepository = iRepOrdersJPA;
    }

    @Override
    public Order getById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

}
