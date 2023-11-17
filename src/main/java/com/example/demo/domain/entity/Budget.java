package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "budget")
@Table(name = "budget")
@EqualsAndHashCode(of = "budget_id")
public class Budget
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long budget_id;

    private Date date;

    private String clientName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    private double totalCost;

    private double discount;

    private double tax = 0.1;

    private double finalCost;

    private boolean bought;

    public void setTotalCost(double cost) {
        this.totalCost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setFinalCost(double finalCost) {
        this.finalCost = finalCost;
    }

    public void setBudget_id(Long budget_id) {
        this.budget_id = budget_id;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getDiscount() {
        return discount;
    }

    public void setBought(boolean bought) {
        bought = bought;
    }

    public boolean getBought() {
        return bought;
    }

    public String getClientName() {
        return clientName;
    }

    public Order getOrder() {
        return order;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getFinalCost() {
        return finalCost;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
