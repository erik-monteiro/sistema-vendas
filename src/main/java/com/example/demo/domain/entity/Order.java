package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "order")
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "order_id")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    private String clientName;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Budget budget;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Item> items;

    public void setClientName(String name) {
        this.clientName = name;
    }

    public String getClientName() {
        return this.clientName;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public void setItems(List<Item> itemList) {
        this.items = itemList;
    }
}

