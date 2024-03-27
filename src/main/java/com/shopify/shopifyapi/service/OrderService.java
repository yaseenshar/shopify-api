package com.shopify.shopifyapi.service;

import com.shopify.shopifyapi.entity.OrderEntity;
import com.shopify.shopifyapi.model.Order;
import com.shopify.shopifyapi.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(Order order) {

        OrderEntity orderEntity = mapToOrderEntity(order);

        var order1 = orderRepository.save(orderEntity);
    }

    private OrderEntity mapToOrderEntity(Order order) {

        return new OrderEntity(order.getId(), order.getConfirmationNumber());
    }

}
