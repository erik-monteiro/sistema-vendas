package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "budget")
@Table(name = "budget")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
