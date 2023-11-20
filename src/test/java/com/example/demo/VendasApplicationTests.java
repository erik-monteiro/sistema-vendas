package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.IRepOrders;
import com.example.demo.domain.entity.Order;
import com.example.demo.domain.entity.Product;
import com.example.demo.domain.entity.Item;
import com.example.demo.domain.service.DiscountPolicyService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;

@SpringBootTest
class VendasApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testDiscount5() {
		String clientName = "Jose";
		int qtdProdutos = 1;
		IRepOrders ordersRep = mock(IRepOrders.class);

		List<Order> orders = Collections.singletonList(createMockOrder(clientName, qtdProdutos));
		when(ordersRep.findByClientName(clientName)).thenReturn(orders);

		DiscountPolicyService dps = new DiscountPolicyService(ordersRep);

		double discount = dps.discountPolicy(clientName);

		assertEquals(0.05, discount);

	}

	@Test
	public void testDiscount25() {
		String clientName = "Maria";
		int qtdProdutos = 1;
		IRepOrders ordersRep = mock(IRepOrders.class);

		List<Order> orders = new ArrayList<>();

		for (int i = 0; i < 11; i++)
			orders.add((createMockOrder(clientName, qtdProdutos))); // cria mais de 10 pedidos

		when(ordersRep.findByClientName(clientName)).thenReturn(orders);

		DiscountPolicyService dps = new DiscountPolicyService(ordersRep);
		double discount = dps.discountPolicy(clientName);

		assertEquals(0.25, discount);

	}

	@Test
	public void testDiscount10() {
		String clientName = "Joao";
		int qtdProdutos = 40;
		IRepOrders ordersRep = mock(IRepOrders.class);

		List<Order> orders = new ArrayList<>();

		for (int i = 0; i < 3; i++)
			orders.add((createMockOrder(clientName, qtdProdutos))); // cria 3 pedidos

		when(ordersRep.findByClientName(clientName)).thenReturn(orders);

		DiscountPolicyService dps = new DiscountPolicyService(ordersRep);
		double discount = dps.discountPolicy(clientName);

		assertEquals(0.10, discount);

	}

	private Order createMockOrder(String clienteName, int qtdProdutos) {
		Order order = mock(Order.class);

		// Simule o cliente
		when(order.getClientName()).thenReturn(clienteName);

		// Simule os itens do pedido
		Item item1 = createMockItem(100L, 2, 180);
		Item item2 = createMockItem(110L, 3, 120);
		Item item3 = createMockItem(120L, qtdProdutos, 250);

		when(order.getItems()).thenReturn(List.of(item1, item2, item3));

		return order;
	}

	private Item createMockItem(Long productId, int quantity, double price) {
		Item item = mock(Item.class);

		// Simule o produto associado ao item
		Product product = mock(Product.class);
		when(product.getPrice()).thenReturn(price);

		when(item.getProduct()).thenReturn(product);
		when(item.getQuantity()).thenReturn(quantity);

		return item;
	}

}
