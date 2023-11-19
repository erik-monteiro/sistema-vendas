package com.example.demo.domain.service;

import com.example.demo.application.usecases.BudgetsStatistic_UC;
import com.example.demo.domain.IRepBudgets;
import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Item;
import com.example.demo.domain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        double finalCost = 0;
        Map<Integer, Double> monthlySales = new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM"); // Formato para obter o mês como número

        if (!budgets.isEmpty()) {
            for (Budget budget : budgets) {
                totalCost += budget.getTotalCost();
                finalCost += budget.getFinalCost();
                Date date = budget.getDate();
                int month = Integer.parseInt(dateFormat.format(date));
                double totalSales = budget.getFinalCost();

                // Somar ao total de vendas do mês
                monthlySales.put(month, monthlySales.getOrDefault(month, 0.0) + totalSales);
            }
            
            // Encontrar o mês com o total mais alto
            int monthWithHighestSales = findMonthWithMaxSales(monthlySales);

            return  "A quantidade total de orçamentos é de: " + budgets.size() + ".\n" 
            + "A média do custo total dos orçamentos cadastrados é: R$" + totalCost / budgets.size() + ".\n" 
            + "A média do custo final dos orçamentos cadastrados é: R$" + finalCost / budgets.size() + ".\n"
            + String.format("O mês %d é o mês com mais vendas", monthWithHighestSales) + ".\n";
        }

        return  "A quantidade total de orçamentos é de: " + budgets.size() + ".\n" 
        + "A média do custo total dos orçamentos cadastrados é: R$0.\n" 
        + "A média do custo final dos orçamentos cadastrados é: R$0.\n";
    }

    private int findMonthWithMaxSales(Map<Integer, Double> monthlySales) {
        int monthWithMaxSales = 0;
        double maxSales = Double.MIN_VALUE;

        for (Map.Entry<Integer, Double> entry : monthlySales.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                monthWithMaxSales = entry.getKey();
            }
        }

        return monthWithMaxSales;
    }
}
