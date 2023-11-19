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

    @Autowired
    public OrderStatisticService(IRepOrders iRepOrders) {
        this.ordersRep = iRepOrders;
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

            return "A quantidade média de ITENS por PEDIDO é de: " + (double) totalItems / orders.size();
        }

        return "A quantidade média de ITENS por PEDIDOo é de: 0";
    }
}
