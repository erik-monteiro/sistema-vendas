package com.example.demo.domain;

import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Item;
import com.example.demo.domain.entity.Order;
import com.example.demo.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class BudgetService
{
    private IRepBudgets budgetRep;

    @Autowired
    public BudgetService(IRepBudgets iRepBudget) {
        this.budgetRep = iRepBudget;
    }

    public List<Budget> getAllBudgets() {
        return budgetRep.all();
    }

    public void saveBudget(Budget budget) {
        budgetRep.save(budget);
    }

    public Budget requestBudget(List<Item> itemList, Order order) {
        double totalCost = calculateTotalCost(itemList);

        Budget budget = new Budget();
        budget.setDate(new Date());
        budget.setClientName(order.getClientName());
        budget.setOrder(order);
        budget.setTotalCost(totalCost);

        return budget;
    }

    public double calculateTotalCost(List<Item> itemList) {
        return itemList.stream()
                .filter(item -> item.getProduct() != null) // Verifica se o produto não é nulo
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

}
