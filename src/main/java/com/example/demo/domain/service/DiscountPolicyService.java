package com.example.demo.domain.service;

import com.example.demo.domain.IRepBudgets;
import com.example.demo.domain.IRepOrders;
import com.example.demo.domain.entity.Budget;
import com.example.demo.domain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiscountPolicyService
{
    private IRepBudgets budgetsRep;
    private IRepOrders ordersRep;

    @Autowired
    public DiscountPolicyService(IRepOrders ordersRep) {
        this.ordersRep = ordersRep;
    }

    

    public double discountPolicy(String clientName) {
        double discount = 0.00;
        if (!clientName.isEmpty()) {
            List<Order> orders = ordersRep.findByClientName(clientName);
            int qtdProdutos = 0;

            for(int i = 0; i <orders.get(orders.size()-1).getItems().size(); i++){
                qtdProdutos += orders.get(orders.size()-1).getItems().get(i).getQuantity();
            }
            
            if(!orders.isEmpty() && qtdProdutos > 5){//desconto padrão de 5% para pedidos com mais de 5 itens
                discount = 0.05;
            }

            if (!orders.isEmpty()) {
                int totalOrders = orders.size();
                double totalSpent = orders.stream()
                                    .skip(Math.max(0, orders.size() - 3))
                                    .mapToDouble(order -> order.getItems().stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity()).sum())
                                    .sum();//pega apenas os gastos dos ultimos 3 pedidos
                double averageSpent = totalSpent / 3;

                if (averageSpent > 10000) {
                    discount = 0.1;

                    discount += Math.min(0.3, Math.floor((averageSpent - 10000) / 10000) * 0.05);//divide a diferença entre gasto medio e 10000 
                    //por 10000 o valor resultante é multiplicado 0,05 e arredondado para baixo
                    //em seguida o resultado é comparado com 0,3(desconto maximo) e o valor resultante
                    //escolhendo o menor valor entre estes, pois o desconto não pode exceder 30%
                }

                if (totalOrders > 10) {
                    discount = Math.max(discount, 0.25); //Escolhe o maior desconto entre as políticas
                }
            }
        }

        return discount;
    }

    public int calculateBudgetValidityDays() {
        LocalDate currentDate = LocalDate.now();
        int baseValidityDays = 21;

        // Períodos de baixa procura (julho, dezembro, janeiro e fevereiro)
        if (currentDate.getMonthValue() == 7 ||  // julho
                (currentDate.getMonthValue() >= 12 ||  currentDate.getMonthValue() <= 1 || currentDate.getMonthValue() <= 2)) {  // dezembro, janeiro, fevereiro
            return 35;
        }

        return baseValidityDays;
    }
}
