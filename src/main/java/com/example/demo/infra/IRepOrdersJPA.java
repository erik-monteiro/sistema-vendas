package com.example.demo.infra;

import com.example.demo.domain.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface IRepOrdersJPA  extends CrudRepository<Order, Long>
        {
}
