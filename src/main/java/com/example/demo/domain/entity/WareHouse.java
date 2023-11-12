package com.example.demo.domain.entity;

import com.example.demo.domain.entity.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "warehouse")
@Table(name = "warehouse")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "warehouse_id")
public class WareHouse
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warehouse_id;

    @Enumerated(EnumType.STRING)
    private Location location;

    private enum Location { BRAZIL, CHILE, BOLIVIA };

    @OneToMany(mappedBy = "warehouse")
    private List<Stock> stocks;

}