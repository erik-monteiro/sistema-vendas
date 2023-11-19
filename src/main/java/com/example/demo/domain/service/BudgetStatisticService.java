package com.example.demo.domain.service;

import com.example.demo.application.usecases.BudgetsStatistic_UC;
import com.example.demo.domain.IRepBudgets;
import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Item;
import com.example.demo.domain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetStatisticService
{
    private IRepBudgets budgetsRep;

    @Autowired
    public BudgetStatisticService(IRepBudgets iRepBudgets) {
        this.budgetsRep = iRepBudgets;
    }

    public String calculateAverageBudgetsTotalCost() {
        List<Budget> budgets = budgetsRep.all();
        double totalCost = 0;

        if (!budgets.isEmpty()) {
            for (Budget budget : budgets) {
                totalCost += budget.getTotalCost();
            }
        }

        return "A média do custo total dos orçamentos cadastrados é: " + totalCost / budgets.size();
    }
}
