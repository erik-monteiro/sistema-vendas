package com.example.demo.domain.service;

import com.example.demo.domain.IRepBudgets;
import com.example.demo.domain.IRepOrders;
import com.example.demo.domain.entity.Item;
import com.example.demo.domain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatisticService {
    private IRepOrders ordersRep;
    //private IRepBudgets budgetsRep;

    @Autowired
    public OrderStatisticService(IRepOrders iRepOrders, IRepBudgets iRepBudgets) {
        this.ordersRep = iRepOrders;
        //this.budgetsRep = iRepBudgets;
    }

    public String calculateAverageItemsPerOrder() {
        List<Order> orders = ordersRep.getAll();
        int totalItems = 0;

        if (!orders.isEmpty()) {
            for (Order order : orders) {
                List<Item> items = order.getItems();
                if (items != null) {
                    totalItems += items.stream()
                            .mapToInt(Item::getQuantity)
                            .sum();
                }
            }

            return "A quantidade total de pedidos é de: " + orders.size() + ".\n" 
            + "A quantidade média de ITENS por PEDIDO é de: " + (double) totalItems / orders.size() + ".\n";
        }

        return "A quantidade média de ITENS por PEDIDO é de: 0";

    }


}
