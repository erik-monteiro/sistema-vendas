package com.example.demo.presenter;

import com.example.demo.application.RequestBudget_UC;
import com.example.demo.domain.service.BudgetService;
import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Item;
import com.example.demo.domain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Budget createBudget(@RequestBody List<Item> itemList, @PathVariable Long orderId) {
        return requestBudgetUC.run(itemList, orderId);
    }
}
