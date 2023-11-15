package com.example.demo.presenter;

import com.example.demo.application.RequestBudget;
import com.example.demo.domain.BudgetService;
import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Item;
import com.example.demo.domain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/budget")
public class BudgetController {
    @Autowired
    private RequestBudget requestBudget;

    @Autowired
    private BudgetService budgetService;

    @PostMapping("/{orderId}")
    public ResponseEntity createBudget(@RequestBody List<Item> itemList, @PathVariable Long orderId) {
        Order order = requestBudget.getOrderById(orderId);

        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O pedido para o ID informado não foi encontrado!");
        }

        Budget budget = budgetService.requestBudget(itemList, order);

        requestBudget.saveBudget(budget);

        return ResponseEntity.ok().build();
    }

}
