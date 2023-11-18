package com.example.demo.domain.service;

import com.example.demo.domain.IRepStocks;
import com.example.demo.domain.dto.ItemDTO;
import com.example.demo.domain.IRepBudgets;
import com.example.demo.domain.IRepOrders;
import com.example.demo.domain.IRepProducts;
import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Item;
import com.example.demo.domain.entity.Order;
import com.example.demo.domain.entity.Product;
import com.example.demo.domain.entity.Stock;

import com.example.demo.infra.IRepStocksJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BudgetService
{
    private IRepBudgets budgetRep;
    private IRepOrders orderRep;
    private IRepProducts productRep;
    private IRepStocks stocksRep;
    private DiscountPolicyService discountPolicyService;

    @Autowired
    public BudgetService(IRepBudgets iRepBudget, IRepOrders iRepOrders, IRepProducts productRep, DiscountPolicyService discountPolicyService, IRepStocks iRepStocks) {
        this.budgetRep = iRepBudget;
        this.orderRep = iRepOrders;
        this.productRep = productRep;
        this.discountPolicyService = discountPolicyService;
        this.stocksRep = iRepStocks;
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

    private Stock chooseStockForProduct(Product product) {
        List<Stock> stocks = product.getStocks();
    
        if (stocks != null && !stocks.isEmpty()) {
            return stocks.get(0); // Escolhe o primeiro estoque associado ao produto

        } else {
            return null;
        }
    }
    

    public Budget createBudget(List<ItemDTO> itemRequests, Long orderId) {
        List<Item> itemList = new ArrayList<>();

        for (ItemDTO itemRequest : itemRequests) {
            Item item = new Item();
            Product product = productRep.getById(itemRequest.getProductId());

            if (product != null) {
                Stock stock = chooseStockForProduct(product);
                assert stock != null;
                if (stock.getCurrentQuantity() > itemRequest.getQuantity()) {
                    item.setProduct(product);
                    item.setQuantity(itemRequest.getQuantity());
                    itemList.add(item);
                    stocksRep.decreaseProductQuantity(itemRequest.getQuantity(), product.getId());
                } else {
                    throw new RuntimeException("O estoque não contém todas as quantidades de produtos do seu pedido.");
                }
            }
        }

        double totalCost = calculateTotalCost(itemList);

        Order order = orderRep.getById(orderId);
        if (order != null) {
            Budget budget = new Budget();
            budget.setDate(new Date());
            budget.setClientName(order.getClientName());
            budget.setOrder(order);
            budget.setTax(0.1);

            budget.setTotalCost(totalCost * (1 + budget.getTax()));

            double discount = discountPolicyService.discountPolicy(order.getClientName());
            budget.setDiscount(discount * 100);

            double finalCost = calculateFinalCost(budget.getTotalCost(), discount);
            budget.setFinalCost(finalCost);
            budget.setBought(true);

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

    public double calculateFinalCost(double totalCost, double discount) {
        return totalCost - (totalCost * discount);
    }

}
