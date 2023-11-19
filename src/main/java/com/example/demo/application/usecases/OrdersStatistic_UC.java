package com.example.demo.application.usecases;

import com.example.demo.domain.service.OrderStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdersStatistic_UC
{
    @Autowired
    private OrderStatisticService orderStatisticService;

    public OrdersStatistic_UC(OrderStatisticService orderStatisticService) {
        this.orderStatisticService = orderStatisticService;
    }

    public String run() {
        return this.orderStatisticService.calculateAverageItemsPerOrder();
    }

}
