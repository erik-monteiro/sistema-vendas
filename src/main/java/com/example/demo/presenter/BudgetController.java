package com.example.demo.presenter;

import com.example.demo.application.dto.ItemDTO;
import com.example.demo.application.usecases.RequestBudget_UC;
import com.example.demo.domain.service.BudgetService;
import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budget")
public class BudgetController {

    @Autowired
    private RequestBudget_UC requestBudgetUC;

    @Autowired
    private BudgetService budgetService;

    @PostMapping("/{orderId}")
    public Budget createBudget(@RequestBody List<ItemDTO> itemList, @PathVariable Long orderId) {
        return requestBudgetUC.run(itemList, orderId);
    }
}
