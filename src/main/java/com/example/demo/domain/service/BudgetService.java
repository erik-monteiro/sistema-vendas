package com.example.demo.domain.service;

import com.example.demo.domain.IRepBudgets;
import com.example.demo.domain.IRepOrders;
import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Item;
import com.example.demo.domain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BudgetService {
    private IRepBudgets budgetRep;
    private IRepOrders orderRep;

    @Autowired
    public BudgetService(IRepBudgets iRepBudget, IRepOrders iRepOrders) {
        this.budgetRep = iRepBudget;
        this.orderRep = iRepOrders;
    }

    public List<Budget> getAllBudgets() {
        return budgetRep.all();
    }

    public void saveBudget(Budget budget) {
        budgetRep.save(budget);
    }

    public Order getOrder(Long orderId) {
        return orderRep.getById(orderId);
    }

    public Budget createBudget(List<Item> itemList, Long orderId) {
        double totalCost = calculateTotalCost(itemList);

        Order order = orderRep.getById(orderId);
        if (order != null) {
            Budget budget = new Budget();
            budget.setDate(new Date());
            budget.setClientName(order.getClientName());
            budget.setOrder(order);
            budget.setTotalCost(totalCost);

            budgetRep.save(budget);
            return budget;
        } else {
            // Adicione um tratamento para quando o Order não for encontrado.
            return null;
        }

    }

    public double calculateTotalCost(List<Item> itemList) {
        return itemList.stream()
                .filter(item -> item.getProduct() != null)
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }
}
