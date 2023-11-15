package com.example.demo.application;

import com.example.demo.domain.BudgetService;
import com.example.demo.domain.IRepOrders;
import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RequestBudget {
    @Autowired
    private BudgetService budgetService;

    @Autowired
    private IRepOrders repOrders;

    public RequestBudget(BudgetService budgetService, IRepOrders repOrders) {
        this.budgetService = budgetService;
        this.repOrders = repOrders;
    }

    public List<Budget> run() {
        return budgetService.getAllBudgets();
    }

    public void saveBudget(Budget budget) {
        budgetService.saveBudget(budget);
    }

    public Order getOrderById(Long orderId) {
        return repOrders.getById(orderId);
    }
}
