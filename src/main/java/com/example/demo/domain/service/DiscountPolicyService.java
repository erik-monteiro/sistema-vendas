package com.example.demo.domain.service;

import com.example.demo.domain.IRepBudgets;
import com.example.demo.domain.IRepOrders;
import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiscountPolicyService
{
    private IRepBudgets budgetsRep;
    private IRepOrders ordersRep;

    @Autowired
    public DiscountPolicyService(IRepBudgets iRepBudgets) {
        this.budgetsRep = iRepBudgets;
    }

    public double discountPolicy(String clientName) {
        double discount = 0.0;

        if (!clientName.isEmpty()) {
            List<Budget> budgets = budgetsRep.findByClientName(clientName);

            if (!budgets.isEmpty()) {
                int totalOrders = budgets.size();
                double totalSpent = budgets.stream().mapToDouble(Budget::getFinalCost).sum();
                double averageSpent = totalSpent / totalOrders;

                if (averageSpent > 10000) {
                    discount = 0.1;

                    discount += Math.min(0.3, Math.floor((averageSpent - 10000) / 10000) * 0.05);
                }

                if (totalOrders > 10) {
                    discount = Math.max(discount, 0.25); // Escolhe o maior desconto entre as políticas
                }
            }
        }

        return discount;
    }

    public int calculateBudgetValidityDays() {
        LocalDate currentDate = LocalDate.now();
        int baseValidityDays = 21;

        // Períodos de baixa procura (julho, dezembro, janeiro e fevereiro)
        if (currentDate.getMonthValue() == 7 ||  // julho
                (currentDate.getMonthValue() >= 12 && currentDate.getMonthValue() <= 2)) {  // dezembro, janeiro, fevereiro
            return 35;
        }

        return baseValidityDays;
    }
}
