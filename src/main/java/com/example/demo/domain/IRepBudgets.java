package com.example.demo.domain;

import com.example.demo.domain.entity.Budget;

import java.util.List;
import java.util.Optional;

public interface IRepBudgets
{
    void save(Budget budget);

    List<Budget> all();

    List<Budget> findByClientName(String clientName);

}
