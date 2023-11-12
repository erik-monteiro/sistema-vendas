package com.example.demo.domain;

import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
