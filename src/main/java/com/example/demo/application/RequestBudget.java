package com.example.demo.application;

import com.example.demo.domain.BudgetService;
import com.example.demo.domain.IRepBudgets;
import com.example.demo.domain.entity.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RequestBudget
{
    @Autowired
    private BudgetService budgetService;

    public RequestBudget(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    public List<Budget> run() {
        return budgetService.getAllBudgets();
    }

    public void saveBudget(Budget budget) {
        budgetService.saveBudget(budget);
    }

}
