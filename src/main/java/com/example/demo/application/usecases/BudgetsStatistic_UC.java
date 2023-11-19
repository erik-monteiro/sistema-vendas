package com.example.demo.application.usecases;

import com.example.demo.domain.service.BudgetStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BudgetsStatistic_UC
{
    @Autowired
    private BudgetStatisticService budgetStatisticService;

    public BudgetsStatistic_UC(BudgetStatisticService budgetStatisticService) {
        this.budgetStatisticService = budgetStatisticService;
    }

    public String run() {
        return this.budgetStatisticService.calculateAverageBudgetsTotalCost();
    }
}
