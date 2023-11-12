package com.example.demo.domain;

import com.example.demo.domain.entity.Budget;

import java.util.List;

public interface IRepBudgets
{
    void save(Budget budget);

    List<Budget> all();

}
