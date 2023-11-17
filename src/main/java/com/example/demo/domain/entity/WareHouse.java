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

    public void decreaseProductQuantity(Product product, int quantity) {
        List<Stock> stocks = getStocks(); // Obtém a lista de estoques associados ao armazém

        for (Stock stock : stocks) {
            if (stock.getProduct().equals(product)) {
                int currentQuantity = stock.getCurrentQuantity();
                int newQuantity = Math.max(0, currentQuantity - quantity);
                stock.setQuantityStock(newQuantity);
                return; // Sai do loop após encontrar o estoque do produto
            }
        }
    }
}