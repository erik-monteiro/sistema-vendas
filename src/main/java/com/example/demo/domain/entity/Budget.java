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

    private double finalCost;

    public void setTotalCost(double cost) {
        this.totalCost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setFinalCost(double finalCost) {
        this.finalCost = finalCost;
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
}
