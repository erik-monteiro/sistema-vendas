package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity(name = "statistic")
@Table(name = "statistic")
@EqualsAndHashCode(of = "statistic_id")
public class Statistic
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long statistic_id;

    private double averageTotalCost;

    private double averageFinalCost;

    private int averageItensPerOrder;

    public double getAverageTotalCost() {
        return averageTotalCost;
    }

    public double getAverageFinalCost() {
        return averageFinalCost;
    }

    public int getAverageItensPerOrder() {
        return averageItensPerOrder;
    }

    public void setAverageItensPerOrder(int averageItensPerOrder) {
        this.averageItensPerOrder = averageItensPerOrder;
    }

    public void setAverageTotalCost(double averageTotalCost) {
        this.averageTotalCost = averageTotalCost;
    }

    public void setAverageFinalCost(double averageFinalCost) {
        this.averageFinalCost = averageFinalCost;
    }
}
