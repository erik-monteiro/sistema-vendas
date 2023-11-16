package com.example.demo.infra;

import com.example.demo.domain.IRepBudgets;
import com.example.demo.domain.entity.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Primary
public class RepBudgetsJPA implements IRepBudgets
{
    private IRepBudgetsJPA iRepBudgetsJPA;

    @Autowired
    public RepBudgetsJPA(IRepBudgetsJPA iRepBudgetsJPA) {
        this.iRepBudgetsJPA = iRepBudgetsJPA;
    }

    @Override
    public void save(Budget budget) {
        this.iRepBudgetsJPA.save(budget);
    }

    @Override
    public List<Budget> all() {
        return this.iRepBudgetsJPA.findAll();
    }

    @Override
    public List<Budget> findByClientName(String clientName) {
        return iRepBudgetsJPA.findAll()
                .stream()
                .filter(budget -> budget.getClientName().equalsIgnoreCase(clientName))
                .collect(Collectors.toList());
    }

}
