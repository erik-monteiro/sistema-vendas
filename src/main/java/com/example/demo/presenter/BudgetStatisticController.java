package com.example.demo.presenter;

import com.example.demo.application.usecases.BudgetsStatistic_UC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/budgets/statistic")
public class BudgetStatisticController
{
    @Autowired
    BudgetsStatistic_UC budgetsStatisticUc;

    @GetMapping
    @CrossOrigin("*")
    public String calculateAverageBudgetsTotalCost() {
        return budgetsStatisticUc.run();
    }
}
