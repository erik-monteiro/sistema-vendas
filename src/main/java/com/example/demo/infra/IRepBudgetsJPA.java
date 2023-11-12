package com.example.demo.infra;

import com.example.demo.domain.entity.Budget;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepBudgetsJPA extends CrudRepository<Budget, Long>
{
    List<Budget> findAll();
}
