package com.example.demo.application.usecases;

import com.example.demo.domain.dto.ItemDTO;
import com.example.demo.domain.service.BudgetService;
import com.example.demo.domain.entity.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RequestBudget_UC
{
    @Autowired
    private BudgetService budgetService;

    public RequestBudget_UC(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    public Budget run(List<ItemDTO> itemList, Long orderId) {
        return this.budgetService.createBudget(itemList, orderId);
    }


}
