package com.example.demo.domain.service;

import com.example.demo.application.dto.ItemDTO;
import com.example.demo.domain.IRepBudgets;
import com.example.demo.domain.IRepOrders;
import com.example.demo.domain.IRepProducts;
import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Item;
import com.example.demo.domain.entity.Order;
import com.example.demo.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BudgetService {
    private IRepBudgets budgetRep;
    private IRepOrders orderRep;

    private IRepProducts productRep;

    @Autowired
    public BudgetService(IRepBudgets iRepBudget, IRepOrders iRepOrders, IRepProducts productRep) {
        this.budgetRep = iRepBudget;
        this.orderRep = iRepOrders;
        this.productRep = productRep;
    }

    public List<Budget> getAllBudgets() {
        return budgetRep.all();
    }

    public void saveBudget(Budget budget) {
        budgetRep.save(budget);
    }

    public Order getOrder(Long orderId) {
        return orderRep.getById(orderId);
    }

    public Budget createBudget(List<ItemDTO> itemRequests, Long orderId) {
        List<Item> itemList = new ArrayList<>();

        for (ItemDTO itemRequest : itemRequests) {
            Item item = new Item();
            Product product = productRep.getById(itemRequest.getProductId());

            if (product != null) {
                item.setProduct(product);
                item.setQuantity(itemRequest.getQuantity());
                itemList.add(item);
            }
        }

        double totalCost = calculateTotalCost(itemList);

        Order order = orderRep.getById(orderId);
        if (order != null) {
            Budget budget = new Budget();
            budget.setDate(new Date());
            budget.setClientName(order.getClientName());
            budget.setOrder(order);
            budget.setTotalCost(totalCost);
            budget.setDiscount(0);
            budget.setFinalCost(100);

            budgetRep.save(budget);
            return budget;
        } else {
            return null;
        }
    }


    public double calculateTotalCost(List<Item> itemList) {
        return itemList.stream()
                .filter(item -> item.getProduct() != null)
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

}
